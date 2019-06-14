package org.activiti.chapter07.catalog73;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.Task;

/**
 * 流程任务添加权限
 * @author yangrong10
 *
 */
public class AddCadidateGroup {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		TaskService taskService = processEngine.getTaskService();

		Group group = identityService.createGroupQuery().groupName("开发组").singleResult();
		Task task = taskService.createTaskQuery().taskId("1").singleResult();
		taskService.addCandidateGroup(task.getId(), group.getId());
	}

	private static Group createGroup(IdentityService identityService, String groupName, String groupType) {
		Group group = identityService.newGroup(UUID.randomUUID().toString());
		group.setName(groupName);
		group.setType(groupType);
		identityService.saveGroup(group);
		return group;
	}
}
