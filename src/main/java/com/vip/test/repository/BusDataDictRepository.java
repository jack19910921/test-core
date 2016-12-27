package com.vip.test.repository;

import com.vip.test.entity.BusDataDict;
import org.springframework.stereotype.Repository;

/**
 * Created by jack08.liu on 2016/11/2.
 */
@Repository
public interface BusDataDictRepository {
    int updateByPrimaryKeySelective(BusDataDict busDataDict);

    BusDataDict selectValueByKey(String cfgKey);

    BusDataDict selectValueByKey1(String cfgKey);
}
