package com.zjty.sharding.config;

import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * 单key分片策略
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-29
 */
@RequiredArgsConstructor
public class UserPreShardAlgo implements PreciseShardingAlgorithm<Date> {

    private final String tablePrefix;

    /**
     * 按照时间分片.
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        return tablePrefix +formatter.format(preciseShardingValue.getValue());
    }
}
