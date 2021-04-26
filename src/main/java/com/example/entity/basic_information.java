package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@Data
@TableName("basic_information")
public class basic_information extends Model<basic_information> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 姓名 
      */
    private String name;

    /**
      * 电话号码 
      */
    private String telephone;

    /**
      * 家庭住址 
      */
    private String address;

    /**
      * 个人简介 
      */
    private String description;

}