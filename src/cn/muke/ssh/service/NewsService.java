package cn.muke.ssh.service;

import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.T_NewsDao;
import cn.muke.ssh.domain.T_News;

/**
 * 业务层
 * @author Cfrjkj
 *
 */
@Transactional					//事务注解
@Stateless
@Path("NewsService")
public class NewsService {

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
	@POST
	@Path("save")
	@Produces("application/json")
	public void save(T_News t_News){
		System.out.println("save");
		t_NewsDao.save(t_News);
	}
	
	/**
	 * 
	 */
	@POST
	@Path("findNews")
	@Produces("application/json")
	public void findNews(@FormParam("para") String para){
		System.out.println("NewsService findNews para = " + para);
	}
}
