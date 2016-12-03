package cn.muke.ssh.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_VisitedDao;
import cn.muke.ssh.domain.T_Visited;


/**
 * 业务层
 * @author Cfrjkj
 *
 */
@Transactional					//事务注解
public class VisitedService {

	/**
	 * 业务层注入的dao类
	 */
	private T_VisitedDao t_VisitedDao;

	public void setT_VisitedDao(T_VisitedDao t_VisitedDao) {
		this.t_VisitedDao = t_VisitedDao;
	}
	
	/**
	 * service中的保存方法
	 */
	public void save(T_Visited t_Visited){
		t_VisitedDao.save(t_Visited);
	}
	
	/**
	 * 判断url是否已经被爬取过
	 * @param url
	 * @return
	 */
	public boolean isVisitedUrl(String url){
		T_Visited tVisited = t_VisitedDao.findByUrl(url);
		return tVisited != null;
	}
}
