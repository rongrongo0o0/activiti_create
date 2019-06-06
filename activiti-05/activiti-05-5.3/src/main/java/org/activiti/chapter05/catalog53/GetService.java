package org.activiti.chapter05.catalog53;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class GetService {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine processEngine = configuration.buildProcessEngine();
		processEngine.getRepositoryService();
		processEngine.getRuntimeService();
		processEngine.getTaskService();
		processEngine.getIdentityService();
		processEngine.getManagementService();
		processEngine.getHistoryService();
		processEngine.getDynamicBpmnService();
	}
}
