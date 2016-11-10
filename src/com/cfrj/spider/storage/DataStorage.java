package com.cfrj.spider.storage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.T_NewsService;
import cn.muke.ssh.service.T_VisitedService;

public class DataStorage {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//加载spring配置文件有3种方式, 注意这三种方式的区别
	private static T_NewsService ns = (T_NewsService) ac.getBean("t_NewsService");
	private static T_VisitedService vs = (T_VisitedService) ac.getBean("t_VisitedService");
	
		
	public static void saveNews(T_News tNews){
		// TODO
		System.out.println("保存有效网页: " + tNews.getTitle() + ":	" + tNews.getUrl());
		ns.save(tNews);
	}
	public static void saveVisited(T_Visited visited){
		// TODO
		System.out.println("保存已爬网页: " + visited.getUrl());
		vs.save(visited);
	}
}
