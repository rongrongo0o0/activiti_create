package org.activiti.chapter04.catalog42;

import org.activiti.engine.ProcessEngineConfiguration;

public class DatabaseSchemaUpdateFalse {
	public static void main(String[] args) {
		/**
		 * databaseSchemaUpdate：false
		 * Activiti启动时，检查数据库，不执行任何操作
		 */
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("schemaUpdate-false.xml");
		// 启动流程
		configuration.buildProcessEngine();
	}
}
