package org.activiti.chapter08.catalog83;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;

public class GetVariable {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		TestVO testVO = (TestVO) taskService.getVariable("8a7e052a-dd78-4431-a542-dbd44898b3b1", "arg0");
		System.out.println(testVO.getName());
	}
}
