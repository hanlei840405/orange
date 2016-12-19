package com.fruit.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hanlei6 on 2016/12/19.
 */
@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 2853213562279352636L;
    protected Long id;
    protected String status;
    protected String creator;
    protected Date created;
    protected String modifier;
    protected Date modified;
    protected int version;
}
