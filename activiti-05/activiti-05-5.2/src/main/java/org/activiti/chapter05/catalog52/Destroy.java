package org.activiti.chapter05.catalog52;

import java.net.URL;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class Destroy {
	public static void main(String[] args) throws ClassNotFoundException {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine.getName());
		// 销毁流程引擎实例
		ProcessEngines.destroy();
		System.out.println(ProcessEngines.getProcessEngines().size());

		ClassLoader classLoader = Destroy.class.getClassLoader();
		URL url = classLoader.getResource("activiti.cfg.xml");
		// 重新加载配置文件
		ProcessEngines.retry(url.toString());
		System.out.println("重新加载配置文件后，流程引擎实例数量：" + ProcessEngines.getProcessEngines().size());
		// 再次尝试销毁
		ProcessEngines.destroy();
		System.out.println(ProcessEngines.getProcessEngines().size());
	}
}
