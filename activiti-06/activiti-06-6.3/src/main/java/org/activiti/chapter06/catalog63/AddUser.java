package org.activiti.chapter06.catalog63;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class AddUser {
	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();

		String id = UUID.randomUUID().toString();
		// 创建User
		User user = identityService.newUser(id);
		user.setFirstName("yang");
		user.setLastName("rong");
		user.setEmail("");
		user.setPassword("abc");
		identityService.saveUser(user);

		User data = identityService.createUserQuery().userId(id).singleResult();
		System.out.println(data.getId() + ":" + data.getLastName());
	}
}
