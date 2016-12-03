package cn.muke.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.muke.ssh.domain.T_Visited;

/**
 * ����ȡҳ������dao��
 * @author Cfrjkj
 *
 */
public class T_VisitedDao extends HibernateDaoSupport{

	public void save(T_Visited visited){
		try {
			this.getHibernateTemplate().save(visited);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			System.out.println("visited.getUrl() = " + visited.getUrl() + ",���� = " + visited.getUrl().length());
		}
	}
	
	/**
	 * @param url
	 * @return
	 */
	public T_Visited findByUrl(String url){
		Session session = this.getSession();//��ȡSession����   
//		  
//		String hql = "from T_Visited where url=" + url;   
//  
//		//����hql��ȡʵ�弯�ϣ��˴���Ҫ��Query����ʵ��   
//  
//		List<T_Visited> list = this.getHibernateTemplate().find(hql);   

		
		List<T_Visited> list = session.createQuery( "from " + T_Visited.class.getName() + " s where url = ? order by id" ).setParameter(0, url).list();
		
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
	
}
