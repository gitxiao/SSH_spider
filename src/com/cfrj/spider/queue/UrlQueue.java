package com.cfrj.spider.queue;

import java.util.HashMap;
import java.util.LinkedList;

import cn.muke.ssh.domain.T_News;

public class UrlQueue {
	//url����
	private static LinkedList<String> urlQueue = new LinkedList<String>();
	private static HashMap<String,T_News> newsMap = new HashMap<String,T_News>();

	/**
	 * LinkedList �����̰߳�ȫ��, ����Ҫ��ͬ����
	 * @param url
	 */
	public synchronized static void addElement(String url,int depth){
		if(!isContains(url)){
			urlQueue.add(url);
			newsMap.put(url, new T_News(url,depth));
//			System.out.println("UrlQueue addElement ����ȡurl: " + url);
//			System.out.println("addElement ��Ӻ�");
//			traversal();
		}else{
//			System.out.println("����ȡ����ַ, ���ٽ������:" + url);
		}
	}
	
	
	public synchronized static void addLastElement(T_News tNews){
		urlQueue.addLast(tNews.getUrl());
		newsMap.put(tNews.getUrl(), tNews);
	}
	
	public synchronized static void addLastElement(String url,int depth){
		urlQueue.addLast(url);
		newsMap.put(url, new T_News(url,depth));
	}
	
	public synchronized static T_News outElement(){
//		System.out.println("outElement ȡ��ǰ:");
//		traversal();

		String url = urlQueue.removeFirst();
		T_News tNews = newsMap.remove(url);
//		System.out.println("outElement ȡ����:");
//		traversal();
		return tNews;
	}
	
	public synchronized static boolean isEmpty() throws Exception{
		boolean b1 = urlQueue.isEmpty();
		boolean b2 = newsMap.isEmpty();
		if(b1 == b2){
			return b1;
		}else{
			throw new Exception("urlQueue �� newsMap��һ����Ϊ�� b1,b2 = " + b1 + "," + b2);
		}
	}
	
	public static int size() throws Exception{
		int i1 = urlQueue.size();
		int i2 = newsMap.size();
		if(i1 == i2){
			return i1;
		}else{
			throw new Exception("urlQueue �� newsMap��һ����Ϊ�� i1,i2 = " + i1 + "," + i2);
		}
	}
	
	public static boolean isContains(String url){
		return urlQueue.contains(url);
	}
	
	public static void traversal(){
		System.out.println("UrlQueue ������ʼ===============================================>>>");
		for(String url : urlQueue){
			System.out.println("url = " + url);
		}
		System.out.println("UrlQueue ��������===============================================<<<");
	}
}
