package com.vip.test.strategy.table;

import lombok.extern.java.Log;
import org.kiwi.data.annotation.TableShardingStrategyName;
import org.kiwi.data.sharding.TableShardingStrategy;
import org.kiwi.data.util.ShardingUtil;

/**
 * Created by jack on 16/12/27.
 */
@Log
@TableShardingStrategyName("test_TableSharding")
public class TestTableShardingStrategy implements TableShardingStrategy {

    @Override
    public String determineCurrentSql(String rawSql, String strategyName, Object shardParameter) {
        String sql = ShardingUtil.replaceAll(strategyName, "bus_data_dict_01", rawSql);
        log.info(sql);
        return sql;
    }

}
