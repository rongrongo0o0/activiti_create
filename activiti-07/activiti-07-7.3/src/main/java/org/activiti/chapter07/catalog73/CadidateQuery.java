package org.activiti.chapter07.catalog73;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class CadidateQuery {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/candidateQuery.bpmn")
				.deploy();
		// 创建用户
		User user1 = createUser(identityService, "zhang", "san", "zhangsan@163.com", "123");
		User user2 = createUser(identityService, "li", "si", "lisi@163.com", "123");
		// 创建用户组
		Group group1 = createGroup(identityService, "经理组", "manager");
		Group group2 = createGroup(identityService, "开发组", "developer");
		// 查询流程定义
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		// 设置流程定义权限
		repositoryService.addCandidateStarterUser(processDefinition.getId(), user1.getId());
		repositoryService.addCandidateStarterUser(processDefinition.getId(), user2.getId());
		repositoryService.addCandidateStarterGroup(processDefinition.getId(), group1.getId());
		repositoryService.addCandidateStarterGroup(processDefinition.getId(), group2.getId());
		// 根据流程定义查询用户组数据
		List<Group> groupList = identityService.createGroupQuery().potentialStarter(processDefinition.getId()).list();
		for (Group group : groupList) {
			System.out.println("具有流程定义权限的group：" + group.getName());
		}
		// 根据用户查询具有权限的流程定义
		List<ProcessDefinition> defList = repositoryService.createProcessDefinitionQuery()
				.startableByUser(user1.getId()).list();
		for (ProcessDefinition def : defList) {
			System.out.println("用户user1具有权限的流程定义：" + def.getName());
		}

	}

	private static User createUser(IdentityService identityService, String firstName, String lastName, String email,
			String passWord) {
		User user = identityService.newUser(UUID.randomUUID().toString());
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(passWord);
		identityService.saveUser(user);
		return user;
	}

	private static Group createGroup(IdentityService identityService, String groupName, String groupType) {
		Group group = identityService.newGroup(UUID.randomUUID().toString());
		group.setName(groupName);
		group.setType(groupType);
		identityService.saveGroup(group);
		return group;
	}
}
