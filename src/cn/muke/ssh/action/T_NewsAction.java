package cn.muke.ssh.action;
import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.NewsService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品action类
 * @author Cfrjkj
 *
 */
public class T_NewsAction extends ActionSupport implements ModelDriven<T_News>{

	/**
	 * 模型驱动使用的类
	 */
	private T_News t_News;

	
	/**
	 * strut2的默认执行函数,如果strut.xml中的action没有配置method属性的话,默认执行这个函数,否则不会执行
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("T_NewsAction execute");
		return Action.SUCCESS;
	}
	
	
	/**
	 * 覆盖继承自ModelDriven的方法,所谓ModelDriven，意思是直接把实体类当成页面数据的收集对象
	 */
	@Override
	public T_News getModel() {
		// TODO Auto-generated method stub
		System.out.println("T_NewsAction getModel");
		if(t_News == null){
			t_News = new T_News();
		}
		return t_News;
	}

	/**
	 * struts和spring整合过程中按名称自动注入的业务类.
	 * 
	 */
	private NewsService t_NewsService;

	
	/**
	 * 这个方法是否调用与struts.xml中的action创建方式有关, 如果action由struts自己创建,则会调用,如果action由spring创建,则不会调用
	 * @param t_NewsService
	 */
	public void setT_NewsService(NewsService t_NewsService) {
		System.out.println("T_NewsAction setT_NewsService");
		this.t_NewsService = t_NewsService;
	}

	/**
	 * 保存商品的方法
	 */
	public String save(){
		System.out.println("T_NewsAction action 中的save");
		t_NewsService.save(t_News);
		return null;
	}
	
	/**
	 * 保存商品的方法,测试能否在外部调用
	 */
	public String save(T_News t_News){
		System.out.println("T_NewsAction action 中的save");
		t_NewsService.save(t_News);
		return null;
	}
}
