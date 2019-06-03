package org.activiti.chapter04.catalog42;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.activiti.engine.ProcessEngineConfiguration;

public class DBCPConfig {
	public static void main(String[] args) throws SQLException {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("dbcp-config.xml");
		// 能正常输出，即完成配置
		DataSource ds = configuration.getDataSource();
		System.out.println(ds);
		ds.getConnection().getMetaData();
		System.out.println(ds.getClass().getName());
	}
}
