package com.cfrj.spider;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.muke.ssh.domain.T_News;
import cn.muke.ssh.service.T_NewsService;

/**
 * ApplicationContext 是 BeanFactory 接口的子接口，它增强了 BeanFactory 的功能，处于 context 包下。很多时候， ApplicationContext 允许以声明式方式操作容器，无须手动创建。可利用如 ContextLoader 的支持类，在 Web 应用启动时自动创建 ApplicationContext。当然，也可以采用编程方式创建 ApplicationContext。

			ApplicationContext包括BeanFactory的全部功能，因此建议优先使用ApplicationContext。除非对于某些内存非常关键的应用，才考虑使用 BeanFactory。
			
			spring为ApplicationContext提供的3种实现分别为：
			
			1、  ClassPathXmlApplicationContext：利用类路径的XML文件来载入Bean定义的信息
			
			[1]  ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
			
			[2]  String[] locations = {"bean1.xml", "bean2.xml", "bean3.xml"};
			
			ApplicationContext ctx = new ClassPathXmlApplication(locations);
			
			2、 FileSystemXmlApplicationContext：利用文件系统中的XMl文件来载入Bean
			
			定义的信息
			
			[1]  ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml"); //加载单个配置文件
			
			[2]  String[] locations = {"bean1.xml", "bean2.xml", "bean3.xml"};
			
			 ApplicationContext ctx = new FileSystemXmlApplicationContext(locations );
			
			//加载多个配置文件
			
			[3]  ApplicationContext ctx =new FileSystemXmlApplicationContext("D:/project/bean.xml");
			
			//根据具体路径加载
			
			3、 XmlWebApplicationContext：从Web系统中的XML文件来载入Bean定义的信息。
			 ServletContext servletContext = request.getSession().getServletContext();    
			 ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
 */
public class Test {

	public static void main(String[] args){
		
		T_News t_News = new T_News("url","title",new Date(),"keyword",1);
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");		//加载spring配置文件有3种方式, 注意这三种方式的区别
		T_NewsService ps = (T_NewsService) ac.getBean("t_NewsService");
		ps.save(t_News);
		
	}
}
