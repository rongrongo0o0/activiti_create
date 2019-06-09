package org.activiti.chapter06.catalog65;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

public class QueryGroupsByUser {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		User user = identityService.createUserQuery().userId("128b1afe-c8ee-447d-b6ad-1d4b1d32741e").singleResult();
		List<Group> list = identityService.createGroupQuery().groupMember(user.getId()).list();
		for (Group group : list) {
			System.out.println(group.getName());
		}
	}
}
