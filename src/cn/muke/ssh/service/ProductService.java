package cn.muke.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.muke.ssh.dao.ProductDao;
import cn.muke.ssh.domain.Product;

/**
 * ҵ���
 * @author Cfrjkj
 *
 */
@Transactional					//����ע��
public class ProductService {

	/**
	 * ҵ���ע���dao��
	 */
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		System.out.println("ProductService setProductDao");
		this.productDao = productDao;
	}
	
	/**
	 * service�еı��淽��
	 */
	public void save(Product product){
		System.out.println("ProductService service�еı��淽�� save");
		productDao.save(product);
	}
}
