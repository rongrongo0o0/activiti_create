package org.activiti.chapter06.catalog61;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class DeleteGroup {
	public static void main(String[] args) {
		// 创建默认流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 获取身份服务组件实例
		IdentityService identityService = processEngine.getIdentityService();

		// 新建group
		UUID id = UUID.randomUUID();
		Group group = identityService.newGroup(id.toString());
		group.setName("职员组");
		group.setType("employee");
		identityService.saveGroup(group);
		System.out.println("保存后用户组数量:" + identityService.createGroupQuery().count());
		// 删除group
		identityService.deleteGroup(id.toString());
		System.out.println("删除后用户组数量:" + identityService.createGroupQuery().count());
	}
}
