package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.ProductDao;
import cn.muke.ssh.domain.Product;

/**
 * 业务层
 * @author Cfrjkj
 *
 */
@Transactional					//事务注解
public class ProductService {

	/**
	 * 业务层注入的dao类
	 */
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		System.out.println("ProductService setProductDao");
		this.productDao = productDao;
	}
	
	/**
	 * service中的保存方法
	 */
	public void save(Product product){
		System.out.println("ProductService service中的保存方法 save");
		productDao.save(product);
	}
}
