package cn.muke.ssh.action;
import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.NewsService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒaction��
 * @author Cfrjkj
 *
 */
public class T_NewsAction extends ActionSupport implements ModelDriven<T_News>{

	/**
	 * ģ������ʹ�õ���
	 */
	private T_News t_News;

	
	/**
	 * strut2��Ĭ��ִ�к���,���strut.xml�е�actionû������method���ԵĻ�,Ĭ��ִ���������,���򲻻�ִ��
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("T_NewsAction execute");
		return Action.SUCCESS;
	}
	
	
	/**
	 * ���Ǽ̳���ModelDriven�ķ���,��νModelDriven����˼��ֱ�Ӱ�ʵ���൱��ҳ�����ݵ��ռ�����
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
	 * struts��spring���Ϲ����а������Զ�ע���ҵ����.
	 * 
	 */
	private NewsService t_NewsService;

	
	/**
	 * ��������Ƿ������struts.xml�е�action������ʽ�й�, ���action��struts�Լ�����,������,���action��spring����,�򲻻����
	 * @param t_NewsService
	 */
	public void setT_NewsService(NewsService t_NewsService) {
		System.out.println("T_NewsAction setT_NewsService");
		this.t_NewsService = t_NewsService;
	}

	/**
	 * ������Ʒ�ķ���
	 */
	public String save(){
		System.out.println("T_NewsAction action �е�save");
		t_NewsService.save(t_News);
		return null;
	}
	
	/**
	 * ������Ʒ�ķ���,�����ܷ����ⲿ����
	 */
	public String save(T_News t_News){
		System.out.println("T_NewsAction action �е�save");
		t_NewsService.save(t_News);
		return null;
	}
}
