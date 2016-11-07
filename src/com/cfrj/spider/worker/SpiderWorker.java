package com.cfrj.spider.worker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

import com.cfrj.spider.fetcher.PageFetcher;
import com.cfrj.spider.handler.ContentHandler;
import com.cfrj.spider.model.FetchedPage;
import com.cfrj.spider.model.SpiderParams;
import com.cfrj.spider.parser.ContentParser;
import com.cfrj.spider.queue.UrlQueue;
import com.cfrj.spider.queue.VisitedUrlQueue;
import com.cfrj.spider.storage.DataStorage;


public class SpiderWorker implements Runnable{
	private static final Logger Log = Logger.getLogger(SpiderWorker.class.getName());
	private PageFetcher fetcher;
	private ContentHandler handler;
	private ContentParser parser;
	private DataStorage store;
	private int threadIndex;
	
	public SpiderWorker(int threadIndex){
		this.threadIndex = threadIndex;
		this.fetcher = new PageFetcher();
		this.handler = new ContentHandler();
		this.parser = new ContentParser();
		this.store = new DataStorage();
	}
	
	@Override
	public void run() {
		// ��¼
		
		
		// ����ץȡURL���в�Ϊ��ʱ��ִ����ȡ����
		// ע�� ����������Ϊ��ʱ��Ҳ��������ȡ�����Ѿ�������
		//     ��Ϊ�п�����UrlQueue��ʱ�գ�����worker�̻߳�û�н��µ�URL�������
		//	        ���ԣ�������������ȴ�ʱ�䣬�ٽ���ץȡ�����λ��ᣩ
		while(!UrlQueue.isEmpty()){
			// �Ӵ�ץȡ��������URL
			String url = UrlQueue.outElement();
			
			//�õ���url�ж��Ƿ��Ѿ���������ץȡ����,�������,������
			if(VisitedUrlQueue.isContains(url)){
				continue;
			}
//			System.out.println("��ȡurl------------------------------------------------------:" + url);
			
			// ץȡURLָ����ҳ�棬������״̬���ҳ�����ݹ��ɵ�FetchedPage����
			FetchedPage fetchedPage = fetcher.getContentFromUrl(url);
			
			// �����ȡҳ��ĺϷ��ԣ������Ƿ񱻽�ֹ
			if(!handler.check(fetchedPage)){
				// �л�IP�Ȳ���
				// TODO
				
				Log.info("���汻��ֹ: Spider-" + threadIndex + ": switch IP to ");
				continue;
			}
			
			// ����ҳ�棬��ȡĿ������
			Object targetData = parser.parse(fetchedPage);
			
			// �洢Ŀ�����ݵ����ݴ洢����DB�����洢����ȡ��Url��VisitedUrlQueue
			store.store(targetData);
			
			// delay
			try {
				Thread.sleep(SpiderParams.DEYLAY_TIME);			//�ȴ���ץȡ��url�������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		fetcher.close();
		Log.info("Spider-" + threadIndex + ": stop...");
	}

		
}