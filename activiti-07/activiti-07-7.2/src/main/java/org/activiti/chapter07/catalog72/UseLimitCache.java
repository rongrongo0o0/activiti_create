package org.activiti.chapter07.catalog72;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.deploy.DefaultDeploymentCache;

public class UseLimitCache {
	public static void main(String[] args) {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("use-limit.cfg.xml");
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		for (int i = 0; i < 10; i++) {
			repositoryService.createDeployment().addClasspathResource("bpmn/default-cache.bpmn").name("dep_" + i)
					.key("key_" + i).deploy();
		}
		ProcessEngineConfigurationImpl processEngineConfigurationImpl = (ProcessEngineConfigurationImpl) processEngine
				.getProcessEngineConfiguration();
		DefaultDeploymentCache cache = (DefaultDeploymentCache) processEngineConfigurationImpl
				.getProcessDefinitionCache();
		// 遍历缓存，输出Map中的key
		int size = cache.size();
		System.out.println(size);
	}
}
