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

	private static int workerNum = 0;
	public static void main(String[] args){
		
		// ��ʼ�����ò���
		initializeParams();

		// ��ʼ����ȡ����
		initializeQueue();
		
		// ����worker�̲߳�����
//		for(int i = 1; i <= SpiderParams.WORKER_NUM; i++){
//			new Thread(new SpiderWorker(i)).start();
//		}
		
		/**
		 * һֱά���߳��������,����һ��������,���¿���һ��
		 */
		try {
			while (true) {
				if(!UrlQueue.isEmpty()){
					if(workerNum < SpiderParams.WORKER_NUM){
						System.out.println("����һ���߳�, �߳���: workerNum = " + workerNum);
						new Thread(new SpiderWorker(0)).start();
						workerNum ++;
						Thread.sleep(500);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * һ���߳̽�����,�߳�������1
	 */
	public static void wokerEnd(){
		workerNum --;
	}
	
	
	/**
	 * ��ʼ�������ļ�����
	 */
	private static void initializeParams(){
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("conf/spider.properties"));
			Properties properties = new Properties();
			properties.load(in);
			
			// �������ļ��ж�ȡ����
			SpiderParams.WORKER_NUM = Integer.parseInt(properties.getProperty("spider.threadNum"));
			SpiderParams.DEYLAY_TIME = Integer.parseInt(properties.getProperty("spider.fetchDelay"));
			SpiderParams.MAX_DEPTH = Integer.parseInt(properties.getProperty("spider.pageMaxDepth"));
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
	 * ׼����ʼ����ȡ����
	 * 896836015
	 */
	private static void initializeQueue(){
		
		UrlQueue.addElement("http://www.mohurd.gov.cn",0);
		UrlQueue.addElement("http://www.hebei.com.cn",0);
		UrlQueue.addElement("http://jizhou.hebei.com.cn",0);
		UrlQueue.addElement("http://www.hengshui.gov.cn",0);
		UrlQueue.addElement("http://www.54hs.com",0);
		UrlQueue.addElement("http://www.hsnsbd.gov.cn",0);
		UrlQueue.addElement("http://www.mwr.gov.cn",0);
		UrlQueue.addElement("http://www.hebwater.gov.cn",0);
		UrlQueue.addElement("http://www.xjslt.gov.cn",0);
		UrlQueue.addElement("http://www.xzwater.gov.cn",0);
		UrlQueue.addElement("http://www.hebei.com.cn",0);
		UrlQueue.addElement("http://www.qhsl.gov.cn",0);
		
	}
}
