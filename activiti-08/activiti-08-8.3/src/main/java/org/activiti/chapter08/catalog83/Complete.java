package org.activiti.chapter08.catalog83;

import java.util.HashMap;
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
 * 任务完成
 * @author yangrong10
 *
 */
public class Complete {
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
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/vacation2.bpmn")
				.deploy();
		// 获取流程定义实例
		ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId())
				.singleResult();
		// 启动流程
		ProcessInstance instance = runtimeService.startProcessInstanceById(definition.getId());

		// 查询任务
		Task task = taskService.createTaskQuery().processInstanceId(instance.getId()).singleResult();
		// 设置参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 2);
		Map<String, Object> vars2 = new HashMap<String, Object>();
		vars2.put("temp", "temp var");
		// taskService.setVariables(task.getId(), map1);
		// taskService.setVariables(task.getId(), map2);
		taskService.complete(task.getId(), vars, vars2);

		// 再次查询任务
		task = taskService.createTaskQuery().processInstanceId(instance.getId()).singleResult();
		String tempVar = (String) taskService.getVariable(task.getId(), "temp");
		System.out.println(tempVar);
		// 查询参数
		int days = (int) taskService.getVariable(task.getId(), "days");
		if (days > 5) {
			System.out.println("请假不通过");
		} else {
			System.out.println("请假通过");
			taskService.complete(task.getId());
		}

	}
}
