package com.cfrj.spider.queue;

import java.util.LinkedList;

public class UrlQueue {
	//url����
	private static LinkedList<String> urlQueue = new LinkedList<String>();

	public synchronized static void addElement(String url){
		if(!isContains(url)){
			urlQueue.add(url);
//			System.out.println("UrlQueue addElement ����ȡurl: " + url);
//			System.out.println("addElement ��Ӻ�");
//			traversal();
		}else{
//			System.out.println("����ȡ����ַ, ���ٽ������:" + url);
		}
	}
	
	public synchronized static void addLastElement(String url){
		urlQueue.addLast(url);
	}
	
	public synchronized static String outElement(){
//		System.out.println("outElement ȡ��ǰ:");
//		traversal();

		String url = urlQueue.removeFirst();
		
//		System.out.println("outElement ȡ����:");
//		traversal();
		return url;
	}
	
	public synchronized static boolean isEmpty(){
		return urlQueue.isEmpty();
	}
	
	public static int size(){
		return urlQueue.size();
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
