package com.cfrj.spider.storage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.T_NewsService;

public class DataStorage {
	
	private ApplicationContext ac;		//加载spring配置文件有3种方式, 注意这三种方式的区别
	private T_NewsService ps;
	public DataStorage(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//加载spring配置文件有3种方式, 注意这三种方式的区别
		ps = (T_NewsService) ac.getBean("t_NewsService");
	}
	public void store(T_News tNews){
		// TODO
		System.out.println("保存网页: " + tNews.getTitle() + ":	" + tNews.getUrl());
		ps.save(tNews);
	}
}
