package com.example.controller;

import com.example.common.Result;
import com.example.entity.basic_information;
import com.example.service.basic_informationService;
import com.example.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import com.example.exception.CustomException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/basic_information")
public class basic_informationController {
    @Resource
    private basic_informationService basic_informationService;
    @Resource
    private HttpServletRequest request;

    public User getUser() {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new CustomException("-1", "请登录");
        }
        return user;
    }

    @PostMapping
    public Result<?> save(@RequestBody basic_information basic_information) {
        return Result.success(basic_informationService.save(basic_information));
    }

    @PutMapping
    public Result<?> update(@RequestBody basic_information basic_information) {
        return Result.success(basic_informationService.updateById(basic_information));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        basic_informationService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.success(basic_informationService.getById(id));
    }

    @GetMapping
    public Result<?> findAll() {
        return Result.success(basic_informationService.list());
    }

    @GetMapping("/page")
    public Result<?> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<basic_information> query = Wrappers.<basic_information>lambdaQuery().like(basic_information::getName, name).orderByDesc(basic_information::getId);;
        return Result.success(basic_informationService.page(new Page<>(pageNum, pageSize), query));
    }

}
