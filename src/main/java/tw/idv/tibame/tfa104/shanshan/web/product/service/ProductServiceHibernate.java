package tw.idv.tibame.tfa104.shanshan.web.product.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

public interface ProductServiceHibernate {
	
	public Product addproduct(Product product);
	List<ProductBO> findById (Integer productId);
	List<ProductBO> findNew();
	List<ProductBO> findByCompanyName(String search);
	List<ProductBO> findProdNameByString(String search);
	List<ProductBO> findByType(Integer typeId);
	List<ProductBO> findByCompanyId(Integer companyId);
	List<ProductBO> getAll();

}
