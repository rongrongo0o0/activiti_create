package org.activiti.chapter07.catalog73;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
/**
 * 添加用户与流程定义的关系（用户权限）
 * @author yangrong10
 *
 */
public class UserCandidate {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份认证服务实例
		IdentityService identityService = processEngine.getIdentityService();
		// 得到流程存储服务实例
		RepositoryService repositoryService = processEngine.getRepositoryService();
		// 部署流程描述文件
		Deployment deployment = repositoryService.createDeployment().addClasspathResource("bpmn/candidateUser.bpmn")
				.deploy();
		// 查询流程定义实体
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId()).singleResult();
		// 查询用户
		User user = identityService.createUserQuery().userId("7ef54495-f4a3-431d-8dc4-68537cca36b8").singleResult();
		// 添加用户与流程定义的关系（用户权限）
		repositoryService.addCandidateStarterUser(processDefinition.getId(), user.getId());

	}
}
