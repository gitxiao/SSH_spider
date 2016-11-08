package cn.muke.ssh.domain;

import java.util.Date;

public class T_News {
	
	private Integer id;
	private String url;
	private String title;
	private Date pubDate;
	private String keyword;
	private Integer depth;
	
	public T_News(){
		
	}
	public T_News(String url, String title, Date pubDate, String keyword,Integer depth) {
		super();
		this.url = url;
		this.title = title;
		this.pubDate = pubDate;
		this.keyword = keyword;
		this.depth = depth;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
	
	
}
