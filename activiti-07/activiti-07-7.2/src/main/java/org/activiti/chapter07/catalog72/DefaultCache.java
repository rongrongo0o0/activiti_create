package org.activiti.chapter07.catalog72;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.deploy.DefaultDeploymentCache;

public class DefaultCache {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		for (int i = 0; i < 10; i++) {
			repositoryService.createDeployment().addClasspathResource("bpmn/default-cache.bpmn").name("dep_" + i)
					.key("key_" + i).deploy();
		}
		ProcessEngineConfigurationImpl processEngineConfiguration = (ProcessEngineConfigurationImpl) processEngine
				.getProcessEngineConfiguration();
		DefaultDeploymentCache cache = (DefaultDeploymentCache) processEngineConfiguration.getProcessDefinitionCache();
		// 遍历缓存，输出Map中的key
		int size = cache.size();
		System.out.println(size);
	}
}
