package org.activiti.chapter06.catalog64;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class AddDeleteUserInfo {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = processEngine.getIdentityService();
		// 创建用户
		String id = UUID.randomUUID().toString();
		createUser(identityService, id, "hou", "zhiping", "houzhiping@163.com", "123");
		// 创建用户信息
		identityService.setUserInfo(id, "age", "30");
		identityService.setUserInfo(id, "sex", "male");
		//删除用户信息
		identityService.deleteUserInfo(id, "sex");
	}

	static void createUser(IdentityService identityService, String id, String firstName, String lastName, String email,
			String password) {
		User user = identityService.newUser(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		identityService.saveUser(user);
	}
}
