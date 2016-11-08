package com.cfrj.spider.fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import cn.muke.ssh.domain.T_News;

import com.cfrj.spider.model.FetchedPage;
import com.cfrj.spider.queue.UrlQueue;
import com.cfrj.spider.queue.VisitedUrlQueue;


public class PageFetcher {
	private static final Logger Log = Logger.getLogger(PageFetcher.class.getName());
	private HttpClient client;
	
	/**
	 * ����HttpClientʵ��������ʼ�����Ӳ���
	 */
	public PageFetcher(){
		// ���ó�ʱʱ��
		HttpParams params = new BasicHttpParams();
	    HttpConnectionParams.setConnectionTimeout(params, 10 * 1000);
	    HttpConnectionParams.setSoTimeout(params, 10 * 1000);	    
		client = new DefaultHttpClient(params);
	}
	
	/**
	 * �����ر�HttpClient����
	 */
	public void close(){
		client.getConnectionManager().shutdown();
	}
	
	
	/**
	 * ��URL
	 * @param url
	 * @return
	 * ����������:<a[\s\S]+?</a>
	 */
	public synchronized FetchedPage getContentFromUrl(T_News tNews){
		URL url = null;
		HttpURLConnection conn = null;  
		InputStreamReader isr = null;
		BufferedReader bReader = null;
		StringBuffer sb = new StringBuffer();
		String defaultEncode = "gb2312";
		String encode = null;
		String urlHeader = null;
		String urlStr = tNews.getUrl();
		try {
			int index = urlStr.indexOf("//");
			url = new URL(urlStr);
			urlHeader = urlStr.substring(0,index + 2) + url.getHost();
			conn = (HttpURLConnection)url.openConnection();     
		    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");     
		    conn.connect(); 
		      
//			encode = getCharset(urlStr,urlHeader);
		    
		    isr = new InputStreamReader(url.openStream(),Charset.forName(defaultEncode));
			encode = getCharset(conn,isr,urlHeader);
//			System.out.println("urlStr,encode = " + urlStr + ", " + encode);
			isr.close();
			isr = null;
			if(encode != null){
				isr = new InputStreamReader(url.openStream(),Charset.forName(encode));
			}else{
				isr = new InputStreamReader(url.openStream(),Charset.forName(defaultEncode));
			}
			bReader = new BufferedReader(isr);
			String temp = "";
			while((temp = bReader.readLine()) != null){
				sb.append(temp + '\n');
			}
			
			// ��URL��������ȡ����
			
//			System.out.println("ҳ������: sb.toString() = " + sb.toString());

						
		} catch (Exception e) {
			// ������ʱ������������쳣����URL�Żش�ץȡ���У�������ȡ
			e.printStackTrace();
			Log.info(">> Put back url: " + url);
			VisitedUrlQueue.addElementWithException(tNews,"�쳣");
//			UrlQueue.addLastElement(urlStr);			//TODO ���·Żض���ʱӦ�ü���,�������һֱ���쳣,������������ȡ
		} finally{
			try {
				if(isr != null){
					isr.close();
					isr = null;
				}
				if(conn != null){
					conn.disconnect();
					conn = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new FetchedPage(urlHeader,tNews, sb.toString(), 1);
	}
	
	/**
	 * ��HttpGet
	 * ����url��ȡ��ҳ����
	 * @param url
	 * @return
	 */
//	public FetchedPage getContentFromUrl_(String url){
//		String content = null;
//		int statusCode = 500;
//		String encode = null;				//����Ӧ�Զ���ȡ
//		// ����Get���󣬲�����Header
//		HttpGet getHttp = new HttpGet(url);	
//		getHttp.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; rv:16.0) Gecko/20100101 Firefox/16.0");
//		HttpResponse response = null;
//		
//		try{
//			encode = getCharset(url);
////			System.out.println("encode = " + encode);
//			// �����Ϣ����
//			response = client.execute(getHttp);
//			statusCode = response.getStatusLine().getStatusCode();
//			HttpEntity entity = response.getEntity();	
//			
//			if(entity != null){
//				// ת��Ϊ�ı���Ϣ, ������ȡ��ҳ���ַ�������ֹ����
//				content = EntityUtils.toString(entity, encode);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			
//			// ������ʱ������������쳣����URL�Żش�ץȡ���У�������ȡ
//			Log.info(">> Put back url: " + url);
////			UrlQueue.addLastElement(url);				
//		}finally{
//		}
//
//		return new FetchedPage("",url, content, statusCode);
//	}
	
	
	/**
	 * ��ȡ��ҳ�ı����ʽ
	 * 
	 */
	public String getCharset(HttpURLConnection conn,InputStreamReader isr,String urlHeader) {   
		  String result = null;     
		  String line = null;
		  try {     
		      String contentType = conn.getContentType();    
//		      System.out.println("contentType = " + contentType);
		      //��header������charset     
		      result = findCharset(contentType);      
		      //���û�ҵ��Ļ�����һ��һ�еĶ���ҳ���html���룬��html������Ѱ��     
		      if(result == null){     
		         BufferedReader reader = new BufferedReader(isr);     
		         line = reader.readLine();     
		         while(line != null) {     
//		        	 System.out.println("line = " + line);
		             if(line.contains("Content-Type") || line.contains("content-Type")) {    
		                 result = findCharset(line);     
		             } 
		             if(result != null){
		            	 break; 
		             }else if(line.contains("<iframe")){
		            	 String iframe = findIframeUrl(urlHeader,line);
//		            	 UrlQueue.addElement(iframe);				//TODO 	iframe��δ���, �Ƿ���Ҫ��ӵ�δ��ȡ����
		            	 return getCharset(iframe,urlHeader);
		             }else if(line.contains("location.href")){
		            	 String location = findLocation(urlHeader,line);
		            	 return getCharset(location,urlHeader);
		             }
		             line = reader.readLine();     
		         }     
		     }     
		 } catch (Exception e) {     
		     // TODO Auto-generated catch block     
		     e.printStackTrace();
		 } finally {   
			 conn.disconnect();   
		 }   
		 return result;     
	 }   
	
	/**
	 * ��ȡ��ҳ�ı����ʽ
	 * 
	 */
	public String getCharset(String link,String urlHeader) {   
		  String result = null;     
		  HttpURLConnection conn = null;   
		  if(link.equals("http://vipmail.hebei.com.cn/cgi-bin/web2cgi/index.cgi")){
//			  System.out.println("link = " + link);
		  }
		  String line = null;
		  try {     
		      URL url = new URL(link);     
		      conn = (HttpURLConnection)url.openConnection();     
		      conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");     
		      conn.connect();     
		      String contentType = conn.getContentType();    
//		      System.out.println("contentType = " + contentType);
		      //��header������charset     
		      result = findCharset(contentType);      
		      //���û�ҵ��Ļ�����һ��һ�еĶ���ҳ���html���룬��html������Ѱ��     
		      if(result == null){     
		         BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));     
		         line = reader.readLine();     
		         while(line != null) {     
//		        	 System.out.println("line = " + line);
		             if(line.contains("Content-Type") || line.contains("content-Type")) {    
		                 result = findCharset(line);     
		             } 
		             if(result != null){
		            	 break; 
		             }else if(line.contains("<iframe")){
		            	 String iframe = findIframeUrl(urlHeader,line);
//		            	 UrlQueue.addElement(iframe);				//TODO 	iframe��δ���, �Ƿ���Ҫ��ӵ�δ��ȡ����
		            	 return getCharset(iframe,urlHeader);
		             }else if(line.contains("location.href")){
		            	 String location = findLocation(urlHeader,line);
		            	 return getCharset(location,urlHeader);
		             }
		             line = reader.readLine();     
		         }     
		     }     
		 } catch (Exception e) {     
		     // TODO Auto-generated catch block     
		     e.printStackTrace();
		     System.out.println("�쳣 link = " + link);
		 } finally {   
			 conn.disconnect();   
		 }   
		 return result;     
	 }     
	      
	 //��������     
	 private String findCharset(String line) { 
		 if(line == null){
			 return null;
		 }
//		 System.out.println("findCharset line = " + line);
	     int x = line.indexOf("charset=");     
	     int y = line.lastIndexOf('\"');     
	     if(x < 0)     
	         return null;     
	     else if(y >= 0)    
	         return line.substring(x + 8, y);    
	     else  
	         return line.substring(x + 8);   
	}
	 
	private String findIframeUrl(String link,String line){
//		System.out.println("findIframeUrl line = " + line);
		int x = line.indexOf("src=");     
//	    int y = line.lastIndexOf('\"');     
	    int y = line.indexOf("\"", x + 6);
	    String iframe = null;
	    if(x < 0)     
	    	iframe = null;     
	    else if(y >= 0)    
	    	iframe = line.substring(x + 5, y);    
	    else  
	    	iframe = line.substring(x + 5);   
	    
	    iframe = iframe.trim();
	    
	    if(iframe.startsWith("http://") || iframe.startsWith("https://")){
	    	iframe = iframe;
		}else{
			iframe = link + iframe;
		}
	    
//	    System.out.println("iframe = " + iframe);
	    return iframe;
	}
	
	private String findLocation(String link,String line){
//		System.out.println("findLocation line = " + line);
		int length = "location.href".length();
		int x = line.indexOf("location.href");     
		int y1 = line.indexOf("\"", x + length);
		int y2 = line.indexOf("\"", y1 + 1);
		String location = null;
		if(x < 0)     
			location = null;     
		else if(y1 > 0 && y2 > y1)    
			location = line.substring(y1 + 1, y2);    
		else  
			location = line.substring(x + length - 1);   
		
		location = location.trim();
		
		if(location.startsWith("http://") || location.startsWith("https://")){
			location = location;
		}else{
			location = link + location;
		}
		
//		System.out.println("location = " + location);
		return location;
	}
}
