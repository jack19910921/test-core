package com.vip.test.spi.impl;

import org.kiwi.http.support.spi.SignProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Component
public class DefaultSignProvider extends SignProvider {

    @Override
    public void doSign(Map<String, String> param, String charset) {

    }
}
