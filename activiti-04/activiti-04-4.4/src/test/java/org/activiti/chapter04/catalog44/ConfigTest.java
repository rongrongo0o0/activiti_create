package org.activiti.chapter04.catalog44;

import org.activiti.engine.ProcessEngineConfiguration;

public class ConfigTest {
	public static void main(String[] args) {
		MyConfiguration configuration = (MyConfiguration) ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("my-config.xml");
		// 启动Activiti
		configuration.buildProcessEngine();
		System.out.println(configuration.getUserName());
	}
}
