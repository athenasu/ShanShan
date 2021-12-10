package tw.idv.tibame.tfa104.shanshan.web.shop.service.impl;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.service.impl.ProductServiceHibernate_impl;
import tw.idv.tibame.tfa104.shanshan.web.shop.dao.ShopDAO;
import tw.idv.tibame.tfa104.shanshan.web.shop.dao.impl.ShopDAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.CartItem;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
//import tw.idv.tibame.tfa104.shanshan.web.shop.service.WishlistProductDao;
//import tw.idv.tibame.tfa104.shanshan.web.shop.service.WishlistProductDaoImpl;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;

public class ShopServiceImpl implements ShopService{

	ProductServiceHibernate pssvc = new ProductServiceHibernate_impl();
	
	ShopDAO dao = new ShopDAOImpl();
	

//	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//	WishlistProductDao dao2 = context.getBean(WishlistProductDaoImpl.class);
	
	//	回傳?個 PopularProduct , 熱門商品 (?個)  按總銷售數 正序
	@Override
	public List<ProductBO> findPopularNum(Integer showNum) {
		return dao.findpopular10(showNum);
	}

//  山友搜尋商品名字功能 條件product_name like '%?%' 按product_id 正序 
	@Override
	public List<ProductBO> findProductByProName(String search_str) {
		return dao.findProductByProName(search_str);
	}

//	山友搜尋店家名字功能 條件company_name like '%?%'  按company_id 正序 
	@Override
	public List<ProductBO> findCompanyByComName(String search_str) {
		return dao.findCompanyByComName(search_str);
	}

// 	顯示全部店家 按company_id 正序 
	@Override
	public List<CompanyVO> findAllCompany() {
		return dao.findAllCompany();
	}

//	顯示特定商品資訊 商品單頁
	@Override
	public List<ProductBO> findProductByProId(Integer product_id) {
		return dao.findProductByProId(product_id);
	}
	
//	顯示特定商品明細 購物車
	@Override
	public ProductBO findProductByProDesId(Integer product_des_id) {
		return dao.findProductByProDesId(product_des_id);
	}

//	顯示特定商家商品?個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findProductByComId(Integer company_id, Integer ingoreNum, Integer showNum) {
		return dao.findProductByComId(company_id, ingoreNum, showNum);
	}

//	顯示指定商品類別的商品?個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findProductByType(Integer product_type, Integer ingoreNum, Integer showNum) {
		return dao.findProductByType(product_type, ingoreNum, showNum);
	}

//	顯示全部商品?個+分頁功能 按照product_id 正序
	@Override
	public List<ProductBO> findAllProduct(Integer ingoreNum, Integer showNum) {
		return dao.findAllProduct(ingoreNum,  showNum);
	}

//	顯示特定店家的資訊
	@Override
	public CompanyVO findCompanyByComId(Integer company_id) {
		return dao.findCompanyByComId(company_id);
	}

//	取得總商品資料條數
	@Override
	public int getTotalProRecord() {
		return dao.getTotalProRecord();
	}

//	取得商品類別 總商品資料條數
	@Override
	public int getTotalProRecordByType(Integer product_type) {
		return dao.getTotalProRecordByType(product_type);
	}


//	查詢特定商品編號的第?張圖片 變數為product_des_id = ? / limit = ? ,1 (?是第1張圖片)
    @Override
	public ProductImgBO getPic(Integer product_id, Integer ingore_num_pic) {
		return dao.getPic(product_id, ingore_num_pic);
	}

//	查詢特定商品編號的第一個商品明細編號的第一張圖片
	@Override
	public ProductImgBO getProDesFirstPic(Integer product_id) {
		return dao.getProDesFirstPic(product_id);
	}

////	查詢特定商品明細編號的全部圖片 按product_img_id 正序
//	@Override
//	public List<ProductImgBO> getAllProDesPic(Integer product_des_id) {
//		return dao.getAllProDesPic(product_des_id);
//	}
//
//	查詢特定商品編號的全部圖片 按product_img_id 正序
	@Override
	public List<ProductImgBO> getAllProPic(Integer product_id) {
		return dao.getAllProPic(product_id);
	}

//  查詢特定會員的WishlistProduct list
	@Override
	public List<WishlistProduct> getWishlistProductsByMemberId(Integer memberId) {
		return dao.getWishlistProductsByMemberId( memberId);
	}
	
	

}
