package org.activiti.chapter06.catalog64;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;

public class UserPicture {
	public static void main(String[] args) {
		// 创建流程引擎实例
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = processEngine.getIdentityService();
		// 创建用户
		String id = UUID.randomUUID().toString();
		createUser(identityService, id, "wu", "haodong", "whd@163.com", "123");
		// 读取图片数据转换为byte数组
		try {
			FileInputStream fis = new FileInputStream(new File(
					"F:\\activitiSpace\\activiti\\activiti-06\\activiti-06-6.4\\src\\main\\resource\\artifact\\picture.png"));
			BufferedImage img = ImageIO.read(fis);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(img, "png", output);
			// 获取图片数据的byte数组
			byte[] picArray = output.toByteArray();
			// 创建picture实例
			Picture picture = new Picture(picArray, "angus image");
			// 为用户设置图片
			identityService.setUserPicture(id, picture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
