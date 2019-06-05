package org.activiti.chapter05.catalog52;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class Register {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("register.xml");
		// 创建引擎实例
		ProcessEngine processEngine = configuration.buildProcessEngine();
		Map<String, ProcessEngine> map = ProcessEngines.getProcessEngines();
		System.err.println(map.size());
		String name = processEngine.getName();
		System.out.println(name);
		ProcessEngines.unregister(processEngine);
		System.out.println("调用 unregister 后引擎数：" + map.size());
	}
}
