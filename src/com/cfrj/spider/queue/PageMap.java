//package com.cfrj.spider.queue;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map.Entry;
//
//import cn.muke.ssh.domain.T_News;
//
//public class PageMap {
//	
//	private static HashMap<String, T_News> urlMap = new HashMap<String, T_News>();
//
//	public synchronized static void addElement(String url,int depth){
//		if(!isContains(url)){
//			T_News tNews = new T_News(url,depth);
//			urlMap.put(url, tNews);
////			System.out.println("UrlQueue addElement 待爬取url: " + url);
////			System.out.println("addElement 添加后");
////			traversal();
//		}else{
////			System.out.println("已爬取的网址, 不再进入队列:" + url);
//		}
//	}
//	
//	public static Iterator getIterator(){
//		return urlMap.entrySet().iterator();
//	}
//	
//	public synchronized static void addLastElement(T_News tNews){
//		urlMap.put(tNews.getUrl(), tNews);
//	}
//	
//	public synchronized static boolean isEmpty(){
//		return urlMap.isEmpty();
//	}
//	
//	public static int size(){
//		return urlMap.size();
//	}
//	
//	public static boolean isContains(String url){
//		return urlMap.containsKey(url);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static void traversal(){
//		//第一种:
//		Iterator iter = urlMap.entrySet().iterator();
//		System.out.println("urlMap 遍历开始===============================================>>>");
//		while (iter.hasNext()) {
//			Entry entry = (Entry) iter.next();
//			Object key = entry.getKey();
//			Object value = entry.getValue();
//			System.out.println("key,value = " + key + "," + value);
//		}
//		System.out.println("urlMap 遍历结束===============================================<<<");
//		
//		//效率高,以后一定要使用此种方式！
//		//第二种:
////		Iterator iter = map.keySet().iterator();
////		while (iter.hasNext()) {
////			Object key = iter.next();
////			Object val = map.get(key);
////		}
//		//效率低,以后尽量少使用！
//		
//	}
//}
