package cn.muke.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.muke.ssh.domain.T_Visited;

/**
 * ����ȡҳ������dao��
 * @author Cfrjkj
 *
 */
public class T_VisitedDao extends HibernateDaoSupport{

	public void save(T_Visited visited){
		this.getHibernateTemplate().save(visited);
	}
	
	public void find(){
		Session se = this.getSession();//��ȡSession����   
		  
		String hql = "from T_Visited where id=" + 1;   
  
		//����hql��ȡʵ�弯�ϣ��˴���Ҫ��Query����ʵ��   
  
		List<T_Visited> list = this.getHibernateTemplate().find(hql);   
  
		String a = list.get(0).getUrl(); 
	}
	
}
