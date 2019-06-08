package org.activiti.chapter04.catalog42;

import org.activiti.engine.ProcessEngineConfiguration;

public class DatabaseSchemaUpdateTrue {
	public static void main(String[] args) {
		/**
		 * databaseSchemaUpdate：true
		 * Activiti启动时，创建数据库，关闭时不执行删除
		 * true（检查后新建数据库）>>create-drop（没有数据库，创建数据库）>>false（检查数据库，没有报错）
		 * 
		 */
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("schemaUpdate-true.xml");
		System.out.println(configuration.getClass().getName());
		// 启动流程
		configuration.buildProcessEngine();
	}
}
