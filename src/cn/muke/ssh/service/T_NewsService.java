package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_NewsDao;
import cn.muke.ssh.domain.T_News;

/**
 * 业务层
 * @author Cfrjkj
 *
 */
@Transactional					//事务注解
public class T_NewsService {

	/**
	 * 业务层注入的dao类
	 */
	private T_NewsDao t_NewsDao;

	public void setT_NewsDao(T_NewsDao t_NewsDao) {
		this.t_NewsDao = t_NewsDao;
	}
	
	/**
	 * service中的保存方法
	 */
	public void save(T_News t_News){
		t_NewsDao.save(t_News);
	}
}
