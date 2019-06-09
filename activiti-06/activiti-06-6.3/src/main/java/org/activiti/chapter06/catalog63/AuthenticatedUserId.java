package org.activiti.chapter06.catalog63;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.identity.Authentication;

public class AuthenticatedUserId {
	public static void main(String[] args) {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		identityService.setAuthenticatedUserId("3");
		System.out.println("当前线程userId：" + Authentication.getAuthenticatedUserId());
		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					identityService.setAuthenticatedUserId("2");
					Thread.sleep(2000);
					System.out.println("线程2的userId：" + Authentication.getAuthenticatedUserId());

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}.start();

		new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					identityService.setAuthenticatedUserId("1");
					Thread.sleep(2000);
					System.out.println("线程1的userId:" + Authentication.getAuthenticatedUserId());

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}.start();
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
