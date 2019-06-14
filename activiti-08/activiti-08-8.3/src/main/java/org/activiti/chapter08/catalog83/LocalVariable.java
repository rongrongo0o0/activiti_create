package org.activiti.chapter08.catalog83;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * setVariable和setVariableLocal
 * @author yangrong10
 *
 */
public class LocalVariable {
	public static void main(String[] args) {
		// 获取流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取任务服务组件
		TaskService taskService = processEngine.getTaskService();
		// 获取运行服务组件
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 获取流程存储服务组件
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 部署流程描述文件
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/vacation.bpmn")
				.deploy();
		// 查找流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		// 启动流程
		ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId());
		// 设置variable
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		taskService.setVariable(task.getId(), "days", 10);
		taskService.setVariableLocal(task.getId(), "target", "欧洲");
		// 查询variable
		System.out.println(taskService.getVariable(task.getId(), "days"));
		System.out.println(taskService.getVariable(task.getId(), "target"));
		System.out.println(taskService.getVariableLocal(task.getId(), "days"));
	}
}
