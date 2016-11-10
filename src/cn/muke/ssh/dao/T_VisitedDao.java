package cn.muke.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.muke.ssh.domain.T_Visited;

/**
 * 已爬取页面管理的dao类
 * @author Cfrjkj
 *
 */
public class T_VisitedDao extends HibernateDaoSupport{

	public void save(T_Visited visited){
		this.getHibernateTemplate().save(visited);
	}
	
	public void find(){
		Session se = this.getSession();//获取Session对象   
		  
		String hql = "from T_Visited where id=" + 1;   
  
		//依据hql获取实体集合，此处不要用Query类来实现   
  
		List<T_Visited> list = this.getHibernateTemplate().find(hql);   
  
		String a = list.get(0).getUrl(); 
	}
	
}
