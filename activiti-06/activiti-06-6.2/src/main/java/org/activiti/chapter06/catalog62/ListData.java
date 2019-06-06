package org.activiti.chapter06.catalog62;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class ListData {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		// 添加用户组列表
		createGroup(identityService, UUID.randomUUID().toString(), "经理组A");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组B");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组C");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组D");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组E");
		// 遍历group
		List<Group> list = identityService.createGroupQuery().list();
		for (Group group : list) {
			System.out.println(group.getName());
		}
	}

	public static void createGroup(IdentityService identityService, String id, String groupName) {
		Group group = identityService.newGroup(id);
		group.setName(groupName);
		group.setType("manager");
		identityService.saveGroup(group);
	}
}
