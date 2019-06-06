package org.activiti.chapter06.catalog61;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class AddGroup {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine.getName());
		IdentityService identityService = processEngine.getIdentityService();

		// 新建Group
		// UUID id = UUID.randomUUID();
		// Group group = identityService.newGroup(id.toString());
		// group.setName("经理组");
		// group.setType("manager");
		// identityService.saveGroup(group);
		// 保存后查询
		// Group data =
		// identityService.createGroupQuery().groupId(group.getId()).singleResult();
		// System.out.println(data.getName());

		// 更新group

		Group data = identityService.createGroupQuery().groupName("经理组").singleResult();
		System.out.println(data.getType());
		data.setName("经理组2");
		identityService.saveGroup(data);
		System.out.println(data.getName());
	}
}
