package org.activiti.chapter06.catalog62;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class NativeQueyTest {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		// 添加用户组列表
		createGroup(identityService, UUID.randomUUID().toString(), "经理组A");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组B");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组C");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组D");
		createGroup(identityService, UUID.randomUUID().toString(), "经理组E");
		// 使用原生sql查询全部数据
		List<Group> list1 = identityService.createNativeGroupQuery().sql("select * from act_id_group").list();
		for (Group group : list1) {
			System.out.println(group.getId() + ":" + group.getName());
		}
		// 使用原生sql按条件查询
		List<Group> list2 = identityService.createNativeGroupQuery()
				.sql("select * from act_id_group where name_ = '经理组C'").list();
		for (Group group : list2) {
			System.out.println(group.getId() + ":" + group.getName());
		}
		// 使用parameter设置查询参数
		List<Group> list3 = identityService.createNativeGroupQuery()
				.sql("select * from act_id_group where name_ = #{name}").parameter("name", "经理组E").list();
		for (Group group : list3) {
			System.out.println(group.getId() + ":" + group.getName());
		}
	}

	public static void createGroup(IdentityService identityService, String id, String groupName) {
		Group group = identityService.newGroup(id);
		group.setName(groupName);
		group.setType("manager");
		identityService.saveGroup(group);
	}
}
