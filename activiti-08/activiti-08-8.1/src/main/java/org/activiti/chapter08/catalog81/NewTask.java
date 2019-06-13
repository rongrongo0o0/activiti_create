package org.activiti.chapter08.catalog81;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * 新建task
 * @author yangrong10
 *
 */
public class NewTask {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		// 保存第一个task，不设置ID
		Task task1 = taskService.newTask();
		// 保存第一个task，设置ID
		Task task2 = taskService.newTask("审核任务");
		taskService.saveTask(task1);
		taskService.saveTask(task2);
	}
}
