package org.activiti.chapter04.catalog41;

import org.activiti.engine.ProcessEngineConfiguration;

public class CreateFromResource_1 {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("my-activiti1.xml");

	}
}
