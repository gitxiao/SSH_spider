package com.cfrj.spider;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import com.cfrj.spider.model.SpiderParams;
import com.cfrj.spider.queue.UrlQueue;
import com.cfrj.spider.worker.SpiderWorker;



public class SpiderStarter {

	public static void main(String[] args){
		
		// 初始化配置参数
		initializeParams();

		// 初始化爬取队列
		initializeQueue();
		
		// 创建worker线程并启动
		for(int i = 1; i <= SpiderParams.WORKER_NUM; i++){
			new Thread(new SpiderWorker(i)).start();
		}
	}
	
	/**
	 * 初始化配置文件参数
	 */
	private static void initializeParams(){
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("conf/spider.properties"));
			Properties properties = new Properties();
			properties.load(in);
			
			// 从配置文件中读取参数
			SpiderParams.WORKER_NUM = Integer.parseInt(properties.getProperty("spider.threadNum"));
			SpiderParams.DEYLAY_TIME = Integer.parseInt(properties.getProperty("spider.fetchDelay"));

			in.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 准备初始的爬取链接
	 */
	private static void initializeQueue(){
		
		UrlQueue.addElement("http://www.mohurd.gov.cn",0);
//		UrlQueue.addElement("http://www.hebei.com.cn",0);
//		UrlQueue.addElement("http://jizhou.hebei.com.cn",0);
//		UrlQueue.addElement("http://www.hengshui.gov.cn",0);
//		UrlQueue.addElement("http://www.54hs.com",0);
//		UrlQueue.addElement("http://www.hsnsbd.gov.cn",0);
//		UrlQueue.addElement("http://www.mwr.gov.cn",0);
//		UrlQueue.addElement("http://www.hebwater.gov.cn",0);
//		UrlQueue.addElement("http://www.xjslt.gov.cn",0);
//		UrlQueue.addElement("http://www.xzwater.gov.cn",0);
//		UrlQueue.addElement("http://www.hebei.com.cn",0);
//		UrlQueue.addElement("http://www.qhsl.gov.cn",0);
		
	}
}
