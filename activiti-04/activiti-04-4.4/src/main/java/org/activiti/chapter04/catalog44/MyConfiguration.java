package org.activiti.chapter04.catalog44;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.CommandInterceptor;

/**
 * 自定义ProcessEngineConfiguration
 * 
 * @author yangrong10
 *
 */
public class MyConfiguration extends ProcessEngineConfigurationImpl {

	private String userName;

	public MyConfiguration() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public CommandInterceptor createTransactionInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}
}
