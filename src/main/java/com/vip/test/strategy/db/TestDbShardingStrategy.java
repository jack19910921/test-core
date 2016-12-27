package com.vip.test.strategy.db;

import lombok.extern.java.Log;
import org.kiwi.data.annotation.DbShardingStrategyName;
import org.kiwi.data.sharding.DbShardingStrategy;

/**
 * Created by jack on 16/12/27.
 */
@Log
@DbShardingStrategyName("test_DbSharding")
public class TestDbShardingStrategy implements DbShardingStrategy {

    @Override
    public String determineDbGroupName(Object shardParameter) {
        log.info("Db sharding parameter:" + shardParameter);
        return "group01";
    }
}
