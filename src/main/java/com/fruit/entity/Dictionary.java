package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hanlei6 on 2016/12/19.
 */
@Setter
@Getter
public class Dictionary extends BaseEntity {
    private static final long serialVersionUID = 1722499553847395989L;
    //自身属性
    private String code;
    private String name;

    // 字典对象
    private Long dictionaryCode;
    private Dictionary dictionary;
}
