package tw.idv.tibame.tfa104.shanshan.web.productDescription.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;

public interface ProductDesDAOHibernate {

	//用ProductId搜尋 得到相關商品資訊
	List <FindByProductIdBO> findByProductId(Integer productId);

	//用ProductDesId搜尋 得到相關資訊
	List <FindByProductIdBO> findByPK(Integer prodesId);
	
	//用ProductDesId搜尋 得到相關資訊 所有狀態 Lulu用
	List <FindByProductIdBO> findByDesId(Integer prodesId);
	
	//用ProdesStock搜尋 得到有庫存的商品資訊
	List <FindByProductIdBO> findByStock(Integer prodesStock);
	
	List <FindByProductIdBO> getAll();
	
	//出貨更新商品庫存數
	public Integer updateProdesStock(Integer prodesId, Integer prodesStock);
	
	//更新商品上下架狀態
	public Integer updateProDesStatusOfShelf(Integer prodesStatus, Integer prodesId);
	
	//新增商品明細
	public Integer addProdes(ProductDesVO productdesVO);
	
	//更新商品明細
	public Integer updateProdes(ProductDesVO productdesVO);
	
}