package com.cfrj.spider.queue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cfrj.spider.storage.DataStorage;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.T_NewsService;

public class VisitedUrlQueue {
	// 已抓取url队列
//	private static LinkedList<String> visitedUrlQueue = new LinkedList<String>();
	private static Map<String,String> visitedPages = new HashMap<String,String>();
	private static Map<String,String> exceptionPages = new HashMap<String,String>();
	private static T_Visited visited = new T_Visited();
	public synchronized static void addElement(T_News tNews,String desc){
		System.out.println("爬取网页: " + desc + "	 " + tNews.getUrl() + ",深度:" + tNews.getDepth() + ",爬取数量:" + size());
		visitedPages.put(tNews.getUrl(), desc);
		visited.setUrl(tNews.getUrl());
		
		visited.setUrl(tNews.getUrl());
		DataStorage.saveVisited(visited);
	}
	
	public synchronized static void addElementWithException(T_News tNews,String desc){
		System.out.println("异常网页: " + desc + "	 " + tNews.getUrl());
		exceptionPages.put(tNews.getUrl(), desc);
	}
	
	public synchronized static boolean isEmpty(){
		return visitedPages.isEmpty();
	}
	
	public static int size(){
		return visitedPages.size();
	}
	
	public static boolean isContains(String url){
		//TODO 需要查询数据库
		return visitedPages.containsKey(url) || exceptionPages.containsKey(url);
	}
}
