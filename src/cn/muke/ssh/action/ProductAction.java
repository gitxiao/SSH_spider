package cn.muke.ssh.action;
import cn.muke.ssh.domain.Product;
import cn.muke.ssh.service.ProductService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒaction��
 * @author Cfrjkj
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	/**
	 * ģ������ʹ�õ���
	 */
	private Product product;

	
	/**
	 * strut2��Ĭ��ִ�к���,���strut.xml�е�actionû������method���ԵĻ�,Ĭ��ִ���������,���򲻻�ִ��
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("ProductAction execute");
		return Action.SUCCESS;
	}
	
	
	/**
	 * ���Ǽ̳���ModelDriven�ķ���,��νModelDriven����˼��ֱ�Ӱ�ʵ���൱��ҳ�����ݵ��ռ�����
	 */
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		System.out.println("ProductAction getModel");
		if(product == null){
			product = new Product();
		}
		return product;
	}

	/**
	 * struts��spring���Ϲ����а������Զ�ע���ҵ����.
	 * 
	 */
	private ProductService productService;

	
	/**
	 * ��������Ƿ������struts.xml�е�action������ʽ�й�, ���action��struts�Լ�����,������,���action��spring����,�򲻻����
	 * @param productService
	 */
	public void setProductService(ProductService productService) {
		System.out.println("ProductAction setProductService");
		this.productService = productService;
	}

	/**
	 * ������Ʒ�ķ���
	 */
	public String save(){
		System.out.println("ProductAction action �е�save");
		productService.save(product);
		return null;
	}
}
