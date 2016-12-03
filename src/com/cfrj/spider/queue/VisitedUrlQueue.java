package com.cfrj.spider.queue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cfrj.spider.storage.DataStorage;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.NewsService;

public class VisitedUrlQueue {
	// 已抓取url队列
//	private static LinkedList<String> visitedUrlQueue = new LinkedList<String>();
	private static Map<String,String> visitedPages = new HashMap<String,String>();
	private static Map<String,String> exceptionPages = new HashMap<String,String>();
	private static T_Visited visited = new T_Visited();
	public synchronized static void addElement(String url,String desc){
//		System.out.println("爬取网页: " + desc + "	 " + url + ",爬取数量:" + size());
		visitedPages.put(url, desc);			//优化速度时可删除
		
		visited.setUrl(url);
		DataStorage.saveVisited(visited);
	}
	
	/**
	 * 异常网页是否应该保存到数据库?
	 * @param url
	 * @param desc
	 */
	public synchronized static void addElementWithException(String url,String desc){
//		System.out.println("异常网页: " + desc + "	 " + tNews.getUrl());
		exceptionPages.put(url, desc);
	}
	
	public synchronized static boolean isEmpty(){
		return visitedPages.isEmpty();
	}
	
	public static int size(){
		return visitedPages.size();
	}
	
	public static boolean isContains(String url){
		//TODO 需要查询数据库
		boolean visited = DataStorage.findVisited(url);
		if(visited){
			System.out.println("已爬 url = " + url);
		}
		return visited;
//		return visited || exceptionPages.containsKey(url);
//		return visitedPages.containsKey(url) || exceptionPages.containsKey(url);
	}
}
