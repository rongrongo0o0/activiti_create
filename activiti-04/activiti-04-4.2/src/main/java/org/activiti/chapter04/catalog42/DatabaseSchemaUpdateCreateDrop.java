package org.activiti.chapter04.catalog42;

import org.activiti.engine.ProcessEngineConfiguration;

public class DatabaseSchemaUpdateCreateDrop {
	public static void main(String[] args) {
		/**
		 * databaseSchemaUpdate：create-drop
		 * 每次Activiti启动时，都重新创建数据库，数据库已有则报错
		 */
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("schemaUpdate-create-drop.xml");
		System.out.println(configuration.getClass().getName());
		// 启动流程
		configuration.buildProcessEngine();
	}
}
