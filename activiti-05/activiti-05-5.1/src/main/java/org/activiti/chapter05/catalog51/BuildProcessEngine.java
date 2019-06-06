package org.activiti.chapter05.catalog51;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class BuildProcessEngine {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("build_engine.xml");
		// 启动流程引擎
		ProcessEngine engine= configuration.buildProcessEngine();
	}
}
