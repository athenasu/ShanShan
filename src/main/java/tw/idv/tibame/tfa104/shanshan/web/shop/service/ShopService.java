package tw.idv.tibame.tfa104.shanshan.web.shop.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;


public interface ShopService {
//	回傳10個 LastesProduct , 最新商品 (10個) 
//	List<ProductBO> findNew();
//	回傳10個 ProductBO , 熱門商品 (10個)  按總銷售數 正序
	List<ProductBO> findPopular10();
	
}
