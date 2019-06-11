package org.activiti.chapter07.catalog71;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class AddClasspathResource {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 创建流程存储服务实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 创建DeploymentBuilder
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		deploymentBuilder.addClasspathResource("artifact/classpath.png");
		deploymentBuilder.deploy();
	}
}
