package org.activiti.chapter04.catalog41;

import org.activiti.engine.ProcessEngineConfiguration;

public class CreateDefault {
	public static void main(String[] args) {
		/**
		 * 读取默认配置文件创建流程配置对象
		 */

		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResourceDefault();
	}
}
