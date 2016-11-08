package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_NewsDao;
import cn.muke.ssh.domain.T_News;

/**
 * ҵ���
 * @author Cfrjkj
 *
 */
@Transactional					//����ע��
public class T_NewsService {

	/**
	 * ҵ���ע���dao��
	 */
	private T_NewsDao t_NewsDao;

	public void setT_NewsDao(T_NewsDao t_NewsDao) {
		this.t_NewsDao = t_NewsDao;
	}
	
	/**
	 * service�еı��淽��
	 */
	public void save(T_News t_News){
		t_NewsDao.save(t_News);
	}
}
