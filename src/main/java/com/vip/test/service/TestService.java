package com.vip.test.service;

import com.vip.test.entity.BusDataDict;

/**
 * Created by jack08.liu on 2016/11/2.
 */
public interface TestService {

    int updateByPrimaryKeySelective(BusDataDict busDataDictModel);

    BusDataDict findValueByKey(String configKey);

    BusDataDict findValueByKey1(String configKey);

    BusDataDict findValueByKey2(String configKey);

}
