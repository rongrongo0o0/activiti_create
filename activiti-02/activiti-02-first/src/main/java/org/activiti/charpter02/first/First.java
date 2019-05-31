package org.activiti.charpter02.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class First {
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = processEngine.getRuntimeService();
		// 获取流程任务组件
		TaskService taskService = processEngine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment().addClasspathResource("./First.bpmn").deploy();
		// 启动流程
		runtimeService.startProcessInstanceByKey("myProcess");
		// 查询第一个任务
		Task task = taskService.createTaskQuery().singleResult();
		System.out.println("第一个任务完成前，当前任务名称：" + task.getName());
		// 完成第一个任务
		taskService.complete(task.getId());
		// 查询第二个任务
		task = taskService.createTaskQuery().singleResult();
		System.out.println("第二个任务完成前，当前任务名称：" + task.getName());
		// 完成第二个任务（流程结束）
		taskService.complete(task.getId());
		task = taskService.createTaskQuery().singleResult();
		System.out.println("流程结束后，查找任务：" + task);
		// 退出
		System.exit(0);
	}
}
