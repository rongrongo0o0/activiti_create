package org.activiti.chapter06.catalog63;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class UpdateUser {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		String id = UUID.randomUUID().toString();
		// 创建用户
		createUser(identityService, id, "hu", "lei", "hulei@163.com", "123");
		// 查询用户
		User data = identityService.createUserQuery().userId(id).singleResult();
		System.out.println(data.getId() + ":" + data.getFirstName() + " " + data.getLastName());
		// 修改用户信息
		data.setPassword("abc");
		identityService.saveUser(data);
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
