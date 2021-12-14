package tw.idv.tibame.tfa104.shanshan.web.productDescription.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;

public interface ProductDesDAOHibernate {

	//用ProductId搜尋 得到相關商品資訊
	List <FindByProductIdBO> findByProductId(Integer productId);

	//用ProductDesId搜尋 得到相關資訊
	List <FindByProductIdBO> findByPK(Integer prodesId);
	
	//用ProdesStock搜尋 得到有庫存的商品資訊
	List <FindByProductIdBO> findByStock(Integer prodesStock);
	
	List <FindByProductIdBO> getAll();
	
}