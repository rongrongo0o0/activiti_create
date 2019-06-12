package org.activiti.chapter07.catalog74;

import java.io.IOException;
import java.io.InputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class GetResource {
	public static void main(String[] args) throws IOException {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("artifact/GetResource.txt")
				.deploy();
		// 查询资源文件
		InputStream is = repositoryService.getResourceAsStream(deployment.getId(), "artifact/GetResource.txt");
		// 读取输入流
		int count = is.available();
		byte[] contens = new byte[count];
		is.read(contens);
		String result = new String(contens);
		// 输出结果
		System.out.println(result);
	}
}
