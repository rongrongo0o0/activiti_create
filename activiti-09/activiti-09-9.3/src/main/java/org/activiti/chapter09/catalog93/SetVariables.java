package org.activiti.chapter09.catalog93;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 设置参数到流程实例
 * @author yangrong10
 *
 */
public class SetVariables {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/variables.bpmn20.xml")
				.deploy();
		// 启动流程
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest");
		// 查询流程实例的执行流
		Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstance.getId())
				.singleResult();
		runtimeService.setVariable(execution.getId(), "days", 5);
		// 查找参数
		System.out.println(runtimeService.getVariable(execution.getId(), "days"));
	}
}
