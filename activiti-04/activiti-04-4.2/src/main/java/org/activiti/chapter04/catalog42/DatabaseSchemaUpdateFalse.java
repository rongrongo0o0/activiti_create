package org.activiti.chapter04.catalog42;

import org.activiti.engine.ProcessEngineConfiguration;

public class DatabaseSchemaUpdateFalse {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("schemaUpdate-false.xml");
		//启动流程
		configuration.buildProcessEngine();
	}
}
