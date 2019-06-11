package org.activiti.chapter07.catalog72;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;

public class SuspendProcessDef {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		// Deployment deployment =
		// deploymentBuilder.addClasspathResource("bpmn/suspendProcessDef.bpmn").deploy();
		// System.out.println(repositoryService.createDeploymentQuery().deploymentId(deployment.getId()).singleResult().getId());
		String defId = repositoryService.createProcessDefinitionQuery().deploymentId("32501").singleResult().getId();
		System.out.println(defId);

		//repositoryService.suspendProcessDefinitionById(defId);
		repositoryService.activateProcessDefinitionById(defId);
	}
}
