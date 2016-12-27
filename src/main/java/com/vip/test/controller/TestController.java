package com.vip.test.controller;

import com.vip.test.entity.BusDataDict;
import com.vip.test.service.TestService;
import lombok.extern.java.Log;
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

    @RequestMapping(value = "/doReadWrite", method = RequestMethod.POST)
    public void doReadWrite() {
        BusDataDict busDataDict = testService.findValueByKey("");
        log.info("result:" + busDataDict);
    }

    @RequestMapping(value = "/doDbSharding", method = RequestMethod.POST)
    public void doDbSharding() {
        BusDataDict busDataDict = testService.findValueByKey1("");
        log.info("result:" + busDataDict);
    }

    @RequestMapping(value = "/doTableSharding", method = RequestMethod.POST)
    public void doTableSharding() {
        BusDataDict busDataDict = testService.findValueByKey2("");
        log.info("result:" + busDataDict);
    }

}
