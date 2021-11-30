package tw.idv.tibame.tfa104.shanshan.web.shop.dao;

import java.lang.reflect.Member;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;


public interface ShopDAO {
//	回傳10個 ProductBO , 熱門商品 (10個)  按總銷售數 正序
	List<ProductBO> findpopular10();

////回傳10個 ProductBO , 最新商品 (10個)  按照order_description_id 倒序
//	
////  山友搜尋商品名字功能 條件product_name like '%?%' ,20個 按product_id 正序 
//	List<ProductBO> findProductByProName();
////	山友搜尋店家名字功能 條件company_name like '%?%',20個  按company_id 正序 
//	List<ProductBO> findCompanyByComName();
////	更新 山山點數 欄位member_points_sum 條件member_id="?" 
//	void UpdateMembPointsByMemId(Integer member_id);
////	查詢點數 選擇member_points_sum 條件member_id = "?" 
//	Member findMembPointsByMemId(Integer member_id);
//// 	顯示全部店家 按company_id 正序 
//	List<CompanyVO> findAllCompany();
////	顯示特定商品資訊 商品單頁
//	List<ProductBO> findProductByProId();
////	顯示特定商家商品10個+分頁功能 按照product_id 正序
//	List<ProductBO> findProductByComId();
////	顯示指定商品類別的商品20個+分頁功能 按照product_id 正序
//	List<ProductBO> findProductByType();
////	顯示全部商品20個+分頁功能 按照product_id 正序
//	List<ProductBO> findAllProduct();
////	顯示特定店家的資訊
//	List<CompanyVO> findCompanyByComId();
	
//  新增 收藏商品 新增列, wishlist_product_id="自動生成"  (不應該存在資料庫，只存SESSION??)
	
	
	
}

