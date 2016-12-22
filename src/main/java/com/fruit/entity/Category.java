package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类目：
 * 一级：小学、初中、高中、高等教育、在职教育、专长教育等
 * 二级：语文、数学、外语、物理、化学、生物、历史、地理、政治、计算机、金融、管理学、造价师、建造师、注册会计师、素描、钢琴等
 * 三级：年级等
 * 四级：系列教程、单场
 * Created by hanlei6 on 2016/12/19.
 */
@Setter
@Getter
public class Category extends BaseEntity {
    private static final long serialVersionUID = -3950455989723800561L;
    // 自身属性
    private String code;
    private String name;
    private String imgUrl;
    private Long sequence;

    // 上级导航属性
    private Long categoryCode;
    private Category category;
    private List<Category> elements = new ArrayList<>();
}
