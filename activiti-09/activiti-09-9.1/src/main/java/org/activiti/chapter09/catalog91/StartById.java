package org.activiti.chapter09.catalog91;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class StartById {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 部署流程描述文件
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/startById.bpmn20.xml")
				.deploy();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		// 设置流程参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("days", 5);

		// 启动流程，生成流程实例
		runtimeService.startProcessInstanceById(processDefinition.getId());
		runtimeService.startProcessInstanceById(processDefinition.getId(), map);
		runtimeService.startProcessInstanceById(processDefinition.getId(), "vacationRequestl");
		runtimeService.startProcessInstanceById(processDefinition.getId(), "vacationRequestl", map);

		long count = runtimeService.createProcessInstanceQuery().count();
		System.out.println("流程实例数量:" + count);
	}
}
