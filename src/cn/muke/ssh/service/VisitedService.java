package cn.muke.ssh.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_VisitedDao;
import cn.muke.ssh.domain.T_Visited;


/**
 * ҵ���
 * @author Cfrjkj
 *
 */
@Transactional					//����ע��
public class VisitedService {

	/**
	 * ҵ���ע���dao��
	 */
	private T_VisitedDao t_VisitedDao;

	public void setT_VisitedDao(T_VisitedDao t_VisitedDao) {
		this.t_VisitedDao = t_VisitedDao;
	}
	
	/**
	 * service�еı��淽��
	 */
	public void save(T_Visited t_Visited){
		t_VisitedDao.save(t_Visited);
	}
	
	/**
	 * �ж�url�Ƿ��Ѿ�����ȡ��
	 * @param url
	 * @return
	 */
	public boolean isVisitedUrl(String url){
		T_Visited tVisited = t_VisitedDao.findByUrl(url);
		return tVisited != null;
	}
}
