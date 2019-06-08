package org.activiti.chapter04.catalog41;

import org.activiti.engine.ProcessEngineConfiguration;

public class CreateFromResource_2 {
	public static void main(String[] args) {
		/**
		 * 读取自定义配置文件创建流程配置对象test
		 */
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("my-activiti2.xml", "test");
	}
}
