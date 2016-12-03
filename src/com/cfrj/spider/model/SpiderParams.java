package com.cfrj.spider.model;

public class SpiderParams {
	/**
	 * 同时爬取的线程数
	 */
	public static int WORKER_NUM = -1;
	
	/**
	 * 待爬url列表为空时, 等待一段时间, 因为可能有新的url被加进来
	 */
	public static int DEYLAY_TIME = -1;
	
	/**
	 * 爬取的最大深度
	 */
	public static int MAX_DEPTH = -1;
}
