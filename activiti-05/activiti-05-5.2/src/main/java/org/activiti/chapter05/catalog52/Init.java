package org.activiti.chapter05.catalog52;

import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class Init {
	public static void main(String[] args) {
		ProcessEngines.init();//
		Map<String, ProcessEngine> map = ProcessEngines.getProcessEngines();
		System.out.println(map.size());
		System.out.println(map.get("default"));// 默认ProcessEngine实例名称
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		String name = processEngine.getName();
		System.out.println(name);
	}
}
