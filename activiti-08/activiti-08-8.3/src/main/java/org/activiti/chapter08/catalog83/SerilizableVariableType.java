package org.activiti.chapter08.catalog83;

import java.io.Serializable;
import java.util.UUID;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class SerilizableVariableType {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到任务服务组件
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.newTask(UUID.randomUUID().toString());
		task.setName("出差申请");
		taskService.saveTask(task);
		// 任务属性设置
		taskService.setVariable(task.getId(), "arg0", new TestVO("crazyit"));
	}
}

class TestVO implements Serializable {
	private String name;

	public TestVO(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}