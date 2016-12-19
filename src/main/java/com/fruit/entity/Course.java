package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hanlei6 on 2016/12/19.
 */
@Setter
@Getter
public class Course extends BaseEntity {

    private static final long serialVersionUID = -1620732475277191608L;
    private String name;
    private String description;

    // 类目信息
    private Long categoryId;
    private Category category;

    // 字典信息：专场、系列等
    private Long dictionaryId;
    private Dictionary dictionary;

    // 上一集课程
    private Long preId;
    private Course pre;

    // 下一集课程
    private Long nextId;
    private Course next;
}
