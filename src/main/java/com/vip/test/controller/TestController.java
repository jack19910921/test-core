package com.vip.test.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.vip.test.entity.BusDataDict;
import com.vip.test.service.TestService;
import lombok.extern.java.Log;
import org.kiwi.http.support.HttpCallback;
import org.kiwi.http.support.HttpTemplate;
import org.kiwi.http.support.exception.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Log
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @Autowired
    HttpTemplate httpTemplate;

    @RequestMapping(value = "/xx", method = RequestMethod.POST)
    public void xx() {
        BusDataDict busDataDict = new BusDataDict();//testService.findValueByKey("CERTIFY.OSP.TIMEOUT");
        busDataDict.setCfgKey("CERTIFY.OSP.TIMEOUT");
        busDataDict.setCfgValue("45000");
        testService.updateByPrimaryKeySelective(busDataDict);
        log.info(JSON.toJSONString(busDataDict));
    }

    @RequestMapping(value = "/yy", method = RequestMethod.POST)
    public void yy() {
        try {
            String result = httpTemplate.doPost("http://xg-open-account.api.vip.com/account/search/queryVipUserNameByIdNo", ImmutableMap.of("idNo", "610122198710093111"), new HttpCallback<String>() {
                @Override
                public String doParseResult(String result) throws HttpException {
                    return result;
                }
            });
            log.info("Result:" + JSON.toJSONString(result));
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
