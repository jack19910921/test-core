package com.vip.test.spi.impl;

import com.vip.test.util.SignatureUtil;
import org.kiwi.http.support.spi.SignProvider;
import org.kiwi.util.IPUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Component
public class DefaultSignProvider extends SignProvider {

    @Override
    public void doSign(Map<String, String> param, String charset) {
        param.put("charSet", "utf-8");
        param.put("partnerId", "80002000018");
        param.put("signType", "MD5");
        param.put("reqTime", System.currentTimeMillis() + "");
        param.put("resultType", "json");
        param.put("versionNo", "1.0.0");
        param.put("ipAddress", IPUtil.getRandomIp());
        param.put("sign", SignatureUtil.sign(param, "ae1c9707bf2ada5fa4f557ba922d9568"));
    }
}
