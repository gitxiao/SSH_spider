package cn.muke.ssh.action;
import cn.muke.ssh.domain.T_Visited;
import cn.muke.ssh.service.T_VisitedService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒaction��
 * @author Cfrjkj
 *
 */
public class T_VisitedAction extends ActionSupport implements ModelDriven<T_Visited>{

	/**
	 * ģ������ʹ�õ���
	 */
	private T_Visited t_Visited;

	
	/**
	 * strut2��Ĭ��ִ�к���,���strut.xml�е�actionû������method���ԵĻ�,Ĭ��ִ���������,���򲻻�ִ��
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("T_VisitedAction execute");
		return Action.SUCCESS;
	}
	
	
	/**
	 * ���Ǽ̳���ModelDriven�ķ���,��νModelDriven����˼��ֱ�Ӱ�ʵ���൱��ҳ�����ݵ��ռ�����
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
	 * struts��spring���Ϲ����а������Զ�ע���ҵ����.
	 * 
	 */
	private T_VisitedService t_VisitedService;

	
	/**
	 * ��������Ƿ������struts.xml�е�action������ʽ�й�, ���action��struts�Լ�����,������,���action��spring����,�򲻻����
	 * @param t_VisitedService
	 */
	public void setT_VisitedService(T_VisitedService t_VisitedService) {
		System.out.println("T_VisitedAction setT_VisitedService");
		this.t_VisitedService = t_VisitedService;
	}

	/**
	 * ������Ʒ�ķ���
	 */
	public String save(){
		System.out.println("T_VisitedAction action �е�save");
		t_VisitedService.save(t_Visited);
		return null;
	}
	
	/**
	 * ������Ʒ�ķ���,�����ܷ����ⲿ����
	 */
	public String save(T_Visited t_Visited){
		System.out.println("T_VisitedAction action �е�save");
		t_VisitedService.save(t_Visited);
		return null;
	}
}
