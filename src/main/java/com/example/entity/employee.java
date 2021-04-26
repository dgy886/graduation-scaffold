package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@Data
@TableName("employee")
public class employee extends Model<employee> {
    /**
      * 主键
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
      * 名称 
      */
    private String name;

    /**
      * 年龄 
      */
    private Integer age;

    /**
      * 性别 
      */
    private String gender;

    /**
      * 家庭住址 
      */
    private String address;

    /**
      * 个人简介 
      */
    private String description;

}