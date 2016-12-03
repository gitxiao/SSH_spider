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
	// ��ץȡurl����
//	private static LinkedList<String> visitedUrlQueue = new LinkedList<String>();
	private static Map<String,String> visitedPages = new HashMap<String,String>();
	private static Map<String,String> exceptionPages = new HashMap<String,String>();
	private static T_Visited visited = new T_Visited();
	public synchronized static void addElement(String url,String desc){
//		System.out.println("��ȡ��ҳ: " + desc + "	 " + url + ",��ȡ����:" + size());
		visitedPages.put(url, desc);			//�Ż��ٶ�ʱ��ɾ��
		
		visited.setUrl(url);
		DataStorage.saveVisited(visited);
	}
	
	/**
	 * �쳣��ҳ�Ƿ�Ӧ�ñ��浽���ݿ�?
	 * @param url
	 * @param desc
	 */
	public synchronized static void addElementWithException(String url,String desc){
//		System.out.println("�쳣��ҳ: " + desc + "	 " + tNews.getUrl());
		exceptionPages.put(url, desc);
	}
	
	public synchronized static boolean isEmpty(){
		return visitedPages.isEmpty();
	}
	
	public static int size(){
		return visitedPages.size();
	}
	
	public static boolean isContains(String url){
		//TODO ��Ҫ��ѯ���ݿ�
		boolean visited = DataStorage.findVisited(url);
		if(visited){
			System.out.println("���� url = " + url);
		}
		return visited;
//		return visited || exceptionPages.containsKey(url);
//		return visitedPages.containsKey(url) || exceptionPages.containsKey(url);
	}
}
