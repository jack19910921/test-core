package com.vip.test.service;

import com.vip.test.entity.BusDataDict;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Transactional
public interface TestService {
    public int updateByPrimaryKeySelective(BusDataDict busDataDictModel);

    BusDataDict findValueByKey(String configKey);
}
