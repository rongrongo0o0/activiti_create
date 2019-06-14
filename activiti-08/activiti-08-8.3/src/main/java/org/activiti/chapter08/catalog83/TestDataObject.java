package org.activiti.chapter08.catalog83;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.DataObject;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * getDataObjects获取task参数
 * @author yangrong10
 *
 */
public class TestDataObject {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获得流程存储服务组件
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 获得运行服务组件
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 获得任务服务组件
		TaskService taskService = processEngine.getTaskService();

		// 部署流程描述文件
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/dataObject.bpmn")
				.deploy();
		// 获取流程定义实例
		ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId())
				.singleResult();
		// 启动流程
		ProcessInstance instance = runtimeService.startProcessInstanceById(definition.getId());

		// 查询任务
		Task task = taskService.createTaskQuery().processInstanceId(instance.getId()).singleResult();
		Map<String, DataObject> map = taskService.getDataObjects(task.getId());
		for (String key : map.keySet()) {
			System.out.println("key:" + key);
		}
	}
}
