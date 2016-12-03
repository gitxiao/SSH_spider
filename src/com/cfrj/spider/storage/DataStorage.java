package com.cfrj.spider.storage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.NewsService;
import cn.muke.ssh.service.VisitedService;

public class DataStorage {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//����spring�����ļ���3�ַ�ʽ, ע�������ַ�ʽ������
	private static NewsService ns = (NewsService) ac.getBean("t_NewsService");
	private static VisitedService vs = (VisitedService) ac.getBean("t_VisitedService");
	
		
	public static void saveNews(T_News tNews){
		// TODO
//		System.out.println("������Ч��ҳ: " + tNews.getTitle() + ":	" + tNews.getUrl());
		ns.save(tNews);
	}
	public static void saveVisited(T_Visited visited){
		// TODO
//		System.out.println("����������ҳ: " + visited.getUrl());
		vs.save(visited);
	}
	public static boolean findVisited(String url){
		// TODO
//		System.out.println("����������ҳ: " + visited.getUrl());
		return vs.isVisitedUrl(url);
	}
}
