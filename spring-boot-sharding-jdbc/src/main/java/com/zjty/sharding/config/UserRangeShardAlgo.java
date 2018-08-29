package com.zjty.sharding.config;

import com.google.common.collect.Range;
import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import lombok.RequiredArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * fusion-platform.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-29
 */
@RequiredArgsConstructor
public class UserRangeShardAlgo implements RangeShardingAlgorithm<Date> {

    private final String tablePrefix;

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Date> rangeShardingValue) {
        Collection<String> result = new LinkedHashSet<>();
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        Range<Date> ranges = rangeShardingValue.getValueRange();
        Date startTime = ranges.lowerEndpoint();
        Date endTime = ranges.upperEndpoint();
        // range.lowerEndpoint() = 2018-08-01
        // range.upperEndpoint() = 2018-10-01
        // 此处应该返回  tablePrefix+201808 , tablePrefix+201809,tablePrefix+201810,
        Calendar cal = Calendar.getInstance();

        while (startTime.getTime() <= endTime.getTime()) {
            result.add(tablePrefix + sdf.format(startTime));
            cal.setTime(startTime);//设置起时间
            cal.add(Calendar.MONTH, 1);
            startTime = cal.getTime();
        }

        return result;
    }
}
