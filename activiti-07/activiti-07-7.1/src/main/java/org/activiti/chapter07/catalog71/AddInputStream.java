package org.activiti.chapter07.catalog71;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;

public class AddInputStream {
	public static void main(String[] args) throws FileNotFoundException {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 创建流程存储服务实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 第一个资源输入流
		FileInputStream fis1 = new FileInputStream(new File("src/main/resources/artifact/flow_inputstream1.png"));
		// 第二个资源输入流
		FileInputStream fis2 = new FileInputStream(new File("src/main/resources/artifact/flow_inputstream2.png"));
		// 创建DeploymentBuilder实例
		DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
		// 为DeploymentBuilder添加资源输入流
		deploymentBuilder.addInputStream("inputA", fis1);
		deploymentBuilder.addInputStream("inputB", fis2);
		// 执行部署方法
		deploymentBuilder.deploy();
	}
}
