package com.cfrj.spider.storage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.T_NewsService;

public class DataStorage {
	
	private ApplicationContext ac;		//����spring�����ļ���3�ַ�ʽ, ע�������ַ�ʽ������
	private T_NewsService ps;
	public DataStorage(){
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//����spring�����ļ���3�ַ�ʽ, ע�������ַ�ʽ������
		ps = (T_NewsService) ac.getBean("t_NewsService");
	}
	public void store(T_News tNews){
		// TODO
		System.out.println("������ҳ: " + tNews.getTitle() + ":	" + tNews.getUrl());
		ps.save(tNews);
	}
}
