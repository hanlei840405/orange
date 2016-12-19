package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hanlei6 on 16-12-16.
 */
@Getter
@Setter
public class Account extends BaseEntity {
    private static final long serialVersionUID = -6776306703932378874L;
    private String username;
    private String password;
}
