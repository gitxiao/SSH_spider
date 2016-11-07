package com.cfrj.spider.model;

public class FetchedPage {
	private String url;
	private String urlHeader;
	private String content;
	private int statusCode;
	private int antiMode = -1;			//����ģʽ,Ĭ��Ϊ-1,������ҳû�з�����ʩ
	
	public FetchedPage(){
		
	}
	
	public FetchedPage(String urlHeader,String url, String content, int statusCode){
		this.urlHeader = urlHeader;
		this.url = url;
		this.content = content;
		this.statusCode = statusCode;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getUrlHeader() {
		return urlHeader;
	}

	public void setUrlHeader(String urlHeader) {
		this.urlHeader = urlHeader;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getAntiMode() {
		return antiMode;
	}

	public void setAntiMode(int antiMode) {
		this.antiMode = antiMode;
	}
	
	
}
