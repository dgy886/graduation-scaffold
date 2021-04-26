package com.example.service;

import com.example.entity.basic_information;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.basic_informationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class basic_informationService extends ServiceImpl<basic_informationMapper, basic_information> {

    @Resource
    private basic_informationMapper basic_informationMapper;

}
