package com.cfrj.spider;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.T_NewsService;

import com.cfrj.spider.model.SpiderParams;
import com.cfrj.spider.queue.UrlQueue;
import com.cfrj.spider.worker.SpiderWorker;



public class SpiderStarter {

	public static void main(String[] args){
		
		// ��ʼ�����ò���
		initializeParams();

		// ��ʼ����ȡ����
		initializeQueue();
		
		// ����worker�̲߳�����
		for(int i = 1; i <= SpiderParams.WORKER_NUM; i++){
			new Thread(new SpiderWorker(i)).start();
		}
	}
	
	/**
	 * ��ʼ�������ļ�����
	 */
	private static void initializeParams(){
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("conf/spider.properties"));
			Properties properties = new Properties();
			properties.load(in);
			
			// �������ļ��ж�ȡ����
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
	 * ׼����ʼ����ȡ����
	 */
	private static void initializeQueue(){
		// ���磬��Ҫץȡ����TOP 250�ĵ�Ӱ��Ϣ���������ӹ�������URLs�����ץȡ����
//		for(int i = 0; i < 250; i += 25){
//			UrlQueue.addElement("http://movie.douban.com/top250?start=" + i);
//			UrlQueue.addElement("http://movie.douban.com/top250?start=" + 0);
//		}
		
//		UrlQueue.addElement("http://movie.douban.com/top250?start=" + 0);
		
		UrlQueue.addElement("http://www.hebei.com.cn");
		UrlQueue.addElement("http://jizhou.hebei.com.cn");
		UrlQueue.addElement("http://www.hengshui.gov.cn");
		UrlQueue.addElement("http://www.54hs.com");
		UrlQueue.addElement("http://www.hsnsbd.gov.cn");
		UrlQueue.addElement("http://www.mwr.gov.cn");
		UrlQueue.addElement("http://www.hebwater.gov.cn");
		UrlQueue.addElement("http://www.xjslt.gov.cn");
		UrlQueue.addElement("http://www.xzwater.gov.cn");
		UrlQueue.addElement("http://www.hebei.com.cn");
		UrlQueue.addElement("http://www.qhsl.gov.cn");
	}
}
