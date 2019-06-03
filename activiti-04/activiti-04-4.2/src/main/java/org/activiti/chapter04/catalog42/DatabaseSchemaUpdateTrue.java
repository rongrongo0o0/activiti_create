package org.activiti.chapter04.catalog42;

import org.activiti.engine.ProcessEngineConfiguration;

public class DatabaseSchemaUpdateTrue {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("schemaUpdate-true.xml");
		System.out.println(configuration.getClass().getName());
		// 启动流程
		configuration.buildProcessEngine();
	}
}
