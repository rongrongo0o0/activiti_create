package org.activiti.chapter09.catalog94;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 触发等待节点
 * 
 * @author yangrong10
 *
 */
public class Trigger {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 部署流程描述文件
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/trigger.bpmn").deploy();
		// 启动流程，得到流程实例
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest");
		// 查找执行流
		Execution execution = runtimeService.createExecutionQuery().activityId("receivetask1").singleResult();
		if (execution != null) {
			System.out.println("当前流程节点：receivetask1");
		}
		// 触发等待节点
		runtimeService.trigger(execution.getId());
		// 查询当前流程id
		Execution execution2 = runtimeService.createExecutionQuery().activityId("usertask1").singleResult();
		if (execution2 != null) {
			System.out.println("当前流程节点：usertask1");
		}
	}

}
