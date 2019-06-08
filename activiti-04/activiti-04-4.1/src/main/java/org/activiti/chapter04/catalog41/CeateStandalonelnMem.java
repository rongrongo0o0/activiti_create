package org.activiti.chapter04.catalog41;

import org.activiti.engine.ProcessEngineConfiguration;

public class CeateStandalonelnMem {
	public static void main(String[] args) {
		/**
		 * 创建默认的配置对象，并且指定了databaseSchemaUpdate和url
		 * 参数：databaseSchemaUpdate:create-drop
		 * 参数url:jdbc:h2:mem activiti
		 */
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		System.out.println(configuration.getDatabaseSchemaUpdate());
		System.out.println(configuration.getJdbcUrl());
	}
}
