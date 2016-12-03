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
 * ҵ���
 * @author Cfrjkj
 *
 */
@Transactional					//����ע��
@Stateless
@Path("NewsService")
public class NewsService {

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
