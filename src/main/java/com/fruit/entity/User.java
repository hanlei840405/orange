package com.fruit.entity;

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
public class User extends ResourceSupport {
    private String username;
    private String realName;
    private int age;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
