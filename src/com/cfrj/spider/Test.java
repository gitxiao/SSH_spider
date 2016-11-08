package com.cfrj.spider;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.T_NewsService;

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
		
		T_News t_News = new T_News("url","title",new Date(),"keyword",1);
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//����spring�����ļ���3�ַ�ʽ, ע�������ַ�ʽ������
		T_NewsService ps = (T_NewsService) ac.getBean("t_NewsService");
		ps.save(t_News);
		
	}
}
