package com.vip.test.service.impl;

import com.vip.test.entity.BusDataDict;
import com.vip.test.repository.BusDataDictRepository;
import com.vip.test.service.TestService;
import org.kiwi.data.annotation.DbSharding;
import org.kiwi.data.annotation.ReadWrite;
import org.kiwi.data.annotation.TableSharding;
import org.kiwi.data.enums.ReadWriteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired(required = false)
    private BusDataDictRepository busDataDictRepo;

    @Override
    public int updateByPrimaryKeySelective(BusDataDict busDataDictModel) {
        return busDataDictRepo.updateByPrimaryKeySelective(busDataDictModel);
    }

    @Override
    @ReadWrite(type = ReadWriteType.READ)
    public BusDataDict findValueByKey(String configKey) {
        return busDataDictRepo.selectValueByKey(configKey);
    }


    @Override
    @DbSharding(strategyName = "test_DbSharding", expression = "#configKey")
    public BusDataDict findValueByKey1(String configKey) {
        return busDataDictRepo.selectValueByKey(configKey);
    }

    @Override
    @TableSharding(strategyName = "test_TableSharding", expression = "#configKey")
    public BusDataDict findValueByKey2(String configKey) {
        return busDataDictRepo.selectValueByKey1(configKey);
    }

}
