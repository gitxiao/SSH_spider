package cn.muke.ssh.action;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.T_VisitedService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商品action类
 * @author Cfrjkj
 *
 */
public class T_VisitedAction extends ActionSupport implements ModelDriven<T_Visited>{

	/**
	 * 模型驱动使用的类
	 */
	private T_Visited t_Visited;

	
	/**
	 * strut2的默认执行函数,如果strut.xml中的action没有配置method属性的话,默认执行这个函数,否则不会执行
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("T_VisitedAction execute");
		return Action.SUCCESS;
	}
	
	
	/**
	 * 覆盖继承自ModelDriven的方法,所谓ModelDriven，意思是直接把实体类当成页面数据的收集对象
	 */
	@Override
	public T_Visited getModel() {
		// TODO Auto-generated method stub
		System.out.println("T_VisitedAction getModel");
		if(t_Visited == null){
			t_Visited = new T_Visited();
		}
		return t_Visited;
	}

	/**
	 * struts和spring整合过程中按名称自动注入的业务类.
	 * 
	 */
	private T_VisitedService t_VisitedService;

	
	/**
	 * 这个方法是否调用与struts.xml中的action创建方式有关, 如果action由struts自己创建,则会调用,如果action由spring创建,则不会调用
	 * @param t_VisitedService
	 */
	public void setT_VisitedService(T_VisitedService t_VisitedService) {
		System.out.println("T_VisitedAction setT_VisitedService");
		this.t_VisitedService = t_VisitedService;
	}

	/**
	 * 保存商品的方法
	 */
	public String save(){
		System.out.println("T_VisitedAction action 中的save");
		t_VisitedService.save(t_Visited);
		return null;
	}
	
	/**
	 * 保存商品的方法,测试能否在外部调用
	 */
	public String save(T_Visited t_Visited){
		System.out.println("T_VisitedAction action 中的save");
		t_VisitedService.save(t_Visited);
		return null;
	}
}
