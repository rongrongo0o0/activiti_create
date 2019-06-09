package org.activiti.chapter06.catalog63;

import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class UserQuery {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		// 创建用户
		String id = UUID.randomUUID().toString();
		createUser(identityService, id, "zhao", "zijun", "zhaozijun@163.com", "123");

		System.out.println("根据用户id查询：" + identityService.createUserQuery().userId(id).singleResult().getId());
		System.out.println(
				"根据用户firstName查询：" + identityService.createUserQuery().userFirstName("zhao").singleResult().getId());
		System.out.println("根据用户firstName模糊查询：" + identityService.createUserQuery().userFirstNameLike("zh").count());
		System.out.println(
				"根据用户lastName查询：" + identityService.createUserQuery().userLastName("zijun").singleResult().getId());
		System.out.println("根据用户lastName模糊查询：" + identityService.createUserQuery().userLastNameLike("jun").count());
		// 使用NativeQuery
		User user = identityService.createNativeUserQuery().sql("select * from act_id_user where id_ = #{id}").parameter("id", id)
				.singleResult();
		System.out.println(user.getId());
	}

	static void createUser(IdentityService identityService, String id, String firstName, String lastName, String email,
			String password) {
		User user = identityService.newUser(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		identityService.saveUser(user);
	}
}
