package cn.muke.ssh.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.muke.ssh.domain.Product;

/**
 * 商品管理的dao类
 * @author Cfrjkj
 *
 */
public class ProductDao extends HibernateDaoSupport{

	public void save(Product product){
		System.out.println("ProductDao dao中的保存方法");
		System.out.println("product.getName() = " + product.getPname());
		System.out.println("product.getPid() = " + product.getPid());
		System.out.println("product.getPrice() = " + product.getPrice());
		this.getHibernateTemplate().save(product);
	}
}
