package cn.muke.ssh.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.muke.ssh.domain.T_News;

/**
 * ҳ������dao��
 * @author Cfrjkj
 *
 */
public class T_NewsDao extends HibernateDaoSupport{

	public void save(T_News t_News){
		this.getHibernateTemplate().save(t_News);
	}
	
}
