package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_VisitedDao;
import cn.muke.ssh.domain.T_Visited;


/**
 * ҵ���
 * @author Cfrjkj
 *
 */
@Transactional					//����ע��
public class T_VisitedService {

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
}
