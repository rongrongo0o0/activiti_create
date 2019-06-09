package org.activiti.chapter06.catalog63;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class DeleteUser {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = processEngine.getIdentityService();
		String id = UUID.randomUUID().toString();
		// 创建用户
		createUser(identityService, id, "hou", "xi", "houxi@163.com", "123");
		System.out.println("删除前：" + identityService.createUserQuery().count());
		// 删除用户
		identityService.deleteUser(id);
		System.out.println("删除后：" + identityService.createUserQuery().count());
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
