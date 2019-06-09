package org.activiti.chapter06.catalog65;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class QueryUserByGroup {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		User user1 = createUser(identityService, UUID.randomUUID().toString(), "yang", "rong", "731747116@qq.com",
				"123");
		User user2 = createUser(identityService, UUID.randomUUID().toString(), "hu", "lei", "huelei@qq.com", "123");
		User user3 = createUser(identityService, UUID.randomUUID().toString(), "hou", "xi", "houxi@qq.com", "123");
		Group group = createGroup(identityService, UUID.randomUUID().toString(), "java");
		identityService.createMembership(user1.getId(), group.getId());
		identityService.createMembership(user2.getId(), group.getId());
		identityService.createMembership(user3.getId(), group.getId());

		// 根据group查询用户
		List<User> list = identityService.createUserQuery().memberOfGroup(group.getId()).list();
		for (User user : list) {
			System.out.println("用户组中的用户：" + user.getId() + "-" + user.getFirstName() + " " + user.getLastName());
		}
	}

	static User createUser(IdentityService identityService, String id, String firstName, String lastName, String email,
			String password) {
		User user = identityService.newUser(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		identityService.saveUser(user);
		return user;
	}

	static Group createGroup(IdentityService identityService, String id, String groupName) {
		Group group = identityService.newGroup(id);
		group.setName(groupName);
		group.setType("developer");
		identityService.saveGroup(group);
		return group;
	}
}
