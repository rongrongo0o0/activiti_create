package org.activiti.chapter08.catalog83;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

public class BasicVariableType {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.newTask();
		taskService.saveTask(task);
		taskService.setVariable(task.getId(), "arg0", false);
	}
}
