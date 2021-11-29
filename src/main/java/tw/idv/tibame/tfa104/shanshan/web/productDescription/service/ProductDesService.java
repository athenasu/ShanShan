package tw.idv.tibame.tfa104.shanshan.web.productDescription.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;

public interface ProductDesService {

	List <FindByProductIdBO> findByProductId(Integer productId);
	List <FindByProductIdBO> findByPK(Integer prodesId);
	List <FindByProductIdBO> findByStock(Integer prodesStock);
	List <FindByProductIdBO> getAll();
}