package org.activiti.chapter06.catalog65;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class CreateMemberShip {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		String id = UUID.randomUUID().toString();
		User user = createUser(identityService, id, "yang", "xinrui", "yxr@163.com", "123");
		Group group = createGroup(identityService, UUID.randomUUID().toString(), "developer");
		identityService.createMembership(user.getId(), group.getId());
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
		group.setType("manager");
		identityService.saveGroup(group);
		return group;
	}
}
