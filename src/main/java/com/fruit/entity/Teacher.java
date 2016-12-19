package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 入驻教育机构
 * Created by hanlei6 on 2016/12/19.
 */
@Setter
@Getter
public class Teacher extends BaseEntity {
    private static final long serialVersionUID = 2704681542813821279L;
    // 个人信息
    private String nick;
    private String realName;
    private String photo; // 头像
    private String images; // 风采照片 json格式{简介(key):图片(img)}
    private String homepage;
    private String title; // 教师资历、头衔,json格式{资料(key):图片(photo)}
    private String contact;
    private String telephone;
    private String email;
    private String weChat;
    private String weiBo;
    private String qq;
    private String province;
    private String city;
    private String district;
    private String address;
    private String subject; // 专长
    private String info;

    // 隶属学校信息
    private Long schoolId;
    private School school;

    // 账户信息
    private Long accountId;
    private Account account;
}
