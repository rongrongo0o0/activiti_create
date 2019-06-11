package org.activiti.chapter07.catalog71;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class AddBPMNModel {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		deploymentBuilder.addBpmnModel("MyCodeProcess", createProcessModel()).name("MyCodeDeploy").deploy();
	}

	private static BpmnModel createProcessModel() {
		// 创建BPMN模型对象
		BpmnModel model = new BpmnModel();
		Process process = new Process();
		process.setId("process");
		process.setName("My Process");
		model.addProcess(process);
		// 开始事件
		StartEvent startEvent = new StartEvent();
		startEvent.setId("startEvent");
		process.addFlowElement(startEvent);
		// 用户任务
		UserTask userTask = new UserTask();
		userTask.setId("userTask");
		userTask.setName("User Task");
		process.addFlowElement(userTask);
		// 结束事件
		EndEvent endEvent = new EndEvent();
		endEvent.setId("endEvent");
		process.addFlowElement(endEvent);
		// 添加流程顺序
		process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
		process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
		return model;
	}
}
