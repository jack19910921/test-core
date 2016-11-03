package com.vip.test.service.impl;

import com.vip.test.entity.BusDataDict;
import com.vip.test.repository.BusDataDictRepository;
import com.vip.test.service.TestService;
import org.kiwi.data.annotation.ReadWrite;
import org.kiwi.data.enums.ReadWriteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Transactional
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private BusDataDictRepository busDataDictRepo;

    @Override
    public int updateByPrimaryKeySelective(BusDataDict busDataDictModel) {
        int i= busDataDictRepo.updateByPrimaryKeySelective(busDataDictModel);
        return i;
    }

    @Override
    @ReadWrite(type = ReadWriteType.READ)
    public BusDataDict findValueByKey(String configKey) {
        return busDataDictRepo.selectValueByKey(configKey);
    }
}
