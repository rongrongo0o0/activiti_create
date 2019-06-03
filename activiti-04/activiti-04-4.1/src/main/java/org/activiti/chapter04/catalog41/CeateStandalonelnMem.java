package org.activiti.chapter04.catalog41;

import org.activiti.engine.ProcessEngineConfiguration;

public class CeateStandalonelnMem {
	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration
				.createStandaloneInMemProcessEngineConfiguration();
		System.out.println(configuration.getDatabaseSchemaUpdate());
		System.out.println(configuration.getJdbcUrl());
	}
}
