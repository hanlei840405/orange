package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 入驻教育机构
 * Created by hanlei6 on 2016/12/19.
 */
@Setter
@Getter
public class School extends BaseEntity {
    private static final long serialVersionUID = -1722741716413489933L;
    private String name;
    private String password;
    private String logo;
    private String images; // 风采照片 json格式{简介(key):图片(img)}
    private String homepage; // 主页
    private String contact;
    private String telephone;
    private String email; // 企业邮箱
    private String weChat; // 微信公众号
    private String weiBo; // 微博公众号
    private String qq; //企业QQ
    private String province;
    private String city;
    private String district;
    private String address;
    private String scope; // 提供教学范围：K12教育、职业教育、高等教育等
    private String info;

    // 账户信息
    private Long accountId;
    private Account account;
}
