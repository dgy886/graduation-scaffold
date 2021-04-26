package com.example.controller;

import com.example.common.Result;
import com.example.entity.employee;
import com.example.service.employeeService;
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
@RequestMapping("/api/employee")
public class employeeController {
    @Resource
    private employeeService employeeService;
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
    public Result<?> save(@RequestBody employee employee) {
        return Result.success(employeeService.save(employee));
    }

    @PutMapping
    public Result<?> update(@RequestBody employee employee) {
        return Result.success(employeeService.updateById(employee));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        employeeService.removeById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<?> findById(@PathVariable Long id) {
        return Result.success(employeeService.getById(id));
    }

    @GetMapping
    public Result<?> findAll() {
        return Result.success(employeeService.list());
    }

    @GetMapping("/page")
    public Result<?> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                                @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        LambdaQueryWrapper<employee> query = Wrappers.<employee>lambdaQuery().like(employee::getName, name).orderByDesc(employee::getId);;
        return Result.success(employeeService.page(new Page<>(pageNum, pageSize), query));
    }

}
