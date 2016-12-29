package com.vip.test.service.vo;

import lombok.Data;

import java.util.Map;

/**
 * Created by jack on 16/12/4.
 */
@Data
public class EmailMessage {

    private final String from = "xxx@qq.com";
    private String to;
    private String subject;
    private Map<String, Object> param;

    private final String charset = "utf-8";
    private String templatePath;

}
