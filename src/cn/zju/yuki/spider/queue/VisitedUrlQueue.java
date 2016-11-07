package cn.zju.yuki.spider.queue;

import java.util.HashMap;
import java.util.Map;

public class VisitedUrlQueue {
	// ��ץȡurl����
//	private static LinkedList<String> visitedUrlQueue = new LinkedList<String>();
	private static Map<String,String> visitedPages = new HashMap<String,String>();
	private static Map<String,String> exceptionPages = new HashMap<String,String>();
	
	public synchronized static void addElement(String url,String desc){
		System.out.println("��ȡ��ҳ: " + desc + "	 " + url);
		visitedPages.put(url, desc);
	}
	
	public synchronized static void addElementWithException(String url,String desc){
		System.out.println("�쳣��ҳ: " + desc + "	 " + url);
		exceptionPages.put(url, desc);
	}
	
	public synchronized static boolean isEmpty(){
		return visitedPages.isEmpty();
	}
	
	public static int size(){
		return visitedPages.size();
	}
	
	public static boolean isContains(String url){
		return visitedPages.containsKey(url) || exceptionPages.containsKey(url);
	}
}
