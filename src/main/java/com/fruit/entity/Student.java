package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 学生
 * Created by hanlei6 on 16-12-16.
 */
@Getter
@Setter
public class Student extends BaseEntity {
    private static final long serialVersionUID = 562504689102468405L;
    private String nick;
    private String realName;
    private String photo;
    private int age;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String cellphone;
    private String email;
    private String weChat;
    private String weiBo;
    private String qq;
    private String province;
    private String city;
    private String district;
    private String address;
    private String school;
    private String grade;

    // 账户信息
    private Long accountId;
    private Account account;
}
