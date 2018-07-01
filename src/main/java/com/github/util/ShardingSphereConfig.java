package com.github.util;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.sql.SQLUtils;
import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShardingSphereConfig {

	public DruidDataSource createDruidDataSource(String name, String url) {

		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setName(name);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("");

		List<Filter> filterList = new ArrayList<>();

		Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
		slf4jLogFilter.setConnectionLogEnabled(false);
		slf4jLogFilter.setResultSetLogEnabled(false);

		slf4jLogFilter.setStatementCreateAfterLogEnabled(false);
		slf4jLogFilter.setStatementPrepareAfterLogEnabled(false);
		slf4jLogFilter.setStatementPrepareCallAfterLogEnabled(false);
		slf4jLogFilter.setStatementParameterSetLogEnabled(false);
		slf4jLogFilter.setStatementExecuteAfterLogEnabled(false);
		slf4jLogFilter.setStatementCloseAfterLogEnabled(false);

		slf4jLogFilter.setStatementExecutableSqlLogEnable(true);
		slf4jLogFilter.setStatementSqlFormatOption(new SQLUtils.FormatOption(true, true));

		filterList.add(slf4jLogFilter);
		druidDataSource.setProxyFilters(filterList);

		return druidDataSource;
	}

	@Bean
	public DataSource dataSource() throws SQLException {

		// 配置真实数据源
		Map<String, DataSource> dataSourceMap = new HashMap<>();
		DataSource masterDataSource = createDruidDataSource("masterDataSource", "jdbc:mysql://localhost:3306/ds_master");
		dataSourceMap.put("ds_master", masterDataSource);
		DataSource slaveDataSource = createDruidDataSource("slaveDataSource", "jdbc:mysql://localhost:3306/ds_slave_0");
		dataSourceMap.put("ds_slave", slaveDataSource);

		// 配置读写分离规则
		MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave"));

		// 获取数据源对象
		DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new HashMap<String, Object>());

		return dataSource;
	}

}


