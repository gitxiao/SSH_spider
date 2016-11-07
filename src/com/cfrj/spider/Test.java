package com.cfrj.spider;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.muke.ssh.action.ProductAction;
import cn.muke.ssh.domain.Product;
import cn.muke.ssh.service.ProductService;

/**
 * ApplicationContext �� BeanFactory �ӿڵ��ӽӿڣ�����ǿ�� BeanFactory �Ĺ��ܣ����� context ���¡��ܶ�ʱ�� ApplicationContext ����������ʽ��ʽ���������������ֶ��������������� ContextLoader ��֧���࣬�� Web Ӧ������ʱ�Զ����� ApplicationContext����Ȼ��Ҳ���Բ��ñ�̷�ʽ���� ApplicationContext��

			ApplicationContext����BeanFactory��ȫ�����ܣ���˽�������ʹ��ApplicationContext�����Ƕ���ĳЩ�ڴ�ǳ��ؼ���Ӧ�ã��ſ���ʹ�� BeanFactory��
			
			springΪApplicationContext�ṩ��3��ʵ�ֱַ�Ϊ��
			
			1��  ClassPathXmlApplicationContext��������·����XML�ļ�������Bean�������Ϣ
			
			[1]  ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			
			[2]  String[] locations = {"bean1.xml", "bean2.xml", "bean3.xml"};
			
			ApplicationContext ctx = new ClassPathXmlApplication(locations);
			
			2�� FileSystemXmlApplicationContext�������ļ�ϵͳ�е�XMl�ļ�������Bean
			
			�������Ϣ
			
			[1]  ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml"); //���ص��������ļ�
			
			[2]  String[] locations = {"bean1.xml", "bean2.xml", "bean3.xml"};
			
			 ApplicationContext ctx = new FileSystemXmlApplicationContext(locations );
			
			//���ض�������ļ�
			
			[3]  ApplicationContext ctx =new FileSystemXmlApplicationContext("D:/project/bean.xml");
			
			//���ݾ���·������
			
			3�� XmlWebApplicationContext����Webϵͳ�е�XML�ļ�������Bean�������Ϣ��
			 ServletContext servletContext = request.getSession().getServletContext();    
			 ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
 */
public class Test {

	public static void main(String[] args){
		
		Product product = new Product(1, "����", 110.0);
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//����spring�����ļ���3�ַ�ʽ, ע�������ַ�ʽ������
		ProductService ps = (ProductService) ac.getBean("productService");
		ps.save(product);
		
	}
}
