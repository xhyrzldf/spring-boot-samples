package com.zjty.sharding.config;

import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.StandardShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * springboot-samples.
 *
 * @author : Matrix [xhyrzldf@foxmail.com]
 * @Date : 18-8-29
 */
@ComponentScan
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    /**
     * 配置sharding jdbc 数据源
     */
    @Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getUserTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("user");
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(
                new StandardShardingStrategyConfiguration(
                        "tm_fetch",
                        new UserPreShardAlgo("user_"),
                        new UserRangeShardAlgo("user_")
                        ));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig,new HashMap<>(),new Properties());
    }

    /**
     * 设置逻辑表与实际表的规则
     */
    TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("user");
        result.setActualDataNodes("ds0.user_201805,ds0.user_201806");
        result.setKeyGeneratorColumnName("primary_id");
        return result;
    }

    /**
     * 原始数据源
     */
    Map<String, DataSource> createDataSourceMap() {
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driver"))
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .build();
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", dataSource);
        return result;
    }
}
