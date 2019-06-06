package org.activiti.chapter05.catalog53;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class Name {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("name.xml");
		// 设置流程引擎名称
		configuration.setProcessEngineName("test");
		// 创建流程引擎实例
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println(ProcessEngines.getProcessEngine("test"));
		System.out.println(processEngine.getName());
	}
}
