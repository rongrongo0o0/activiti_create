package org.activiti.chapter05.catalog53;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class Close {
	public static void main(String[] args) throws InterruptedException {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("close.xml");
		// 创建流程引擎实例
		ProcessEngine processEngine = configuration.buildProcessEngine();
		Thread.sleep(10000);
		processEngine.close();
	}
}
