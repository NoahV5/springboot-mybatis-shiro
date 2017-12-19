package com.victor.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Aaron on 2017/12/19.
 * 动态数据源
 */
public class DynamicDataSource  extends AbstractRoutingDataSource {

	@Override protected Object determineCurrentLookupKey() {
		return   DynamicDataSourceContextHolder.getDataSourceType();
	}
}
