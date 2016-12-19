package com.fruit.vo;

import com.fruit.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by hanlei6 on 16-12-16.
 */
@Getter
@Setter
public class Student extends ResourceSupport {
    private String username;
    private String realName;
    private int age;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String cellphone;
    private String province;
    private String city;
    private String district;
    private String address;
    private String school;
    private String grade;
}
