package com.cfrj.spider.model;

import cn.muke.ssh.domain.T_News;

public class FetchedPage {
	private T_News tNews;
	private String urlHeader;
	private String content;
	private int statusCode;
	private int antiMode = -1;			//反爬模式,默认为-1,即该网页没有反爬措施
	
	public FetchedPage(){
		
	}
	
	public FetchedPage(String urlHeader,T_News tNews, String content, int statusCode){
		this.urlHeader = urlHeader;
		this.tNews = tNews;
		this.content = content;
		this.statusCode = statusCode;
	}
	
	public String getUrl(){
		return gettNews().getUrl();
	}
	
	public T_News gettNews() {
		return tNews;
	}

	public void settNews(T_News tNews) {
		this.tNews = tNews;
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
