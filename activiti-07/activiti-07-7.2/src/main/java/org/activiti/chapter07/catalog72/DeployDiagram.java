package org.activiti.chapter07.catalog72;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * 流程图部署
 * @author yangrong10
 *
 */
public class DeployDiagram {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 使用DeploymenBuilder部署流程描述图及流程图
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/diagram.bpmn")
				.addClasspathResource("bpmn/diagram.png").deploy();
		System.out.println(repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId())
				.singleResult().getId());
	}
}
