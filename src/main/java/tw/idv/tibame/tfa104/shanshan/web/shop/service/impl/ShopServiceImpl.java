package tw.idv.tibame.tfa104.shanshan.web.shop.service.impl;

import java.util.List;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.service.impl.ProductServiceHibernate_impl;
import tw.idv.tibame.tfa104.shanshan.web.shop.dao.ShopDAO;
import tw.idv.tibame.tfa104.shanshan.web.shop.dao.impl.ShopDAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;

public class ShopServiceImpl implements ShopService{
//	ProductDAOHibernate dao = new ProductDAOHibernate_impl();
//	ProductServiceHibernate pssvc = new ProductServiceHibernate_impl();
	ShopDAO dao2 = new ShopDAOImpl();

//		回傳10個 LastesProduct , 最新商品 (10個) 
//	@Override
//	public List<ProductBO> findNew() {
//		return pssvc.findNew();
//	}
	
	
	//	回傳10個 PopularProduct , 熱門商品 (10個)  按總銷售數 正序
	@Override
	public List<ProductBO> findPopular10() {
		return dao2.findpopular10();
	}

}
