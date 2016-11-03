package com.vip.test.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Data
public class BusDataDict implements java.io.Serializable{
    private Long dictId;
    private String cfgType;
    private String cfgKey;
    private String cfgValue;
    private String cfgName;
    private Date createTime;
    private Date updateTime;
    private Byte isDeleted;
}
