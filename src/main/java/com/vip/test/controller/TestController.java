package com.vip.test.controller;

import com.vip.test.service.TestService;
import lombok.extern.java.Log;
import org.kiwi.http.support.HttpTemplate;
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

    }

    @RequestMapping(value = "/yy", method = RequestMethod.POST)
    public void yy() {

    }
}
