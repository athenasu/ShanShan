package tw.idv.tibame.tfa104.shanshan.web.shop.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;


public interface ShopDAO {
//	商品
//	回傳10個 ProductBO , 熱門商品 (?個)  按總銷售數 正序
	List<ProductBO> findpopular10(Integer showNum);
//  山友搜尋商品名字功能 條件product_name like '%?%' 按product_id 正序 
	List<ProductBO> findProductByProName(String search_str);
//	顯示特定商品資訊 商品單頁
	List<ProductBO> findProductByProId(Integer product_id);
//	顯示特定商品明細 購物車
	ProductBO findProductByProDesId(Integer product_des_id);
//	顯示特定商家商品?個+分頁功能 按照product_id 正序
	List<ProductBO> findProductByComId(Integer company_id,Integer ingoreNum, Integer showNum);
//	顯示指定商品類別的商品?個+分頁功能 按照product_id 正序
	List<ProductBO> findProductByType(Integer product_type,Integer ingoreNum, Integer showNum);
//	顯示全部商品?個+分頁功能 按照product_id 正序
	List<ProductBO> findAllProduct(Integer ingoreNum, Integer showNum);
//	取得總商品資料條數
	int getTotalProRecord();
//	取得商品類別 總商品資料條數
	int getTotalProRecordByType(Integer product_type);
	
//	店家
//	山友搜尋店家名字功能 條件company_name like '%?%'  按company_id 正序 
	List<ProductBO> findCompanyByComName(String search_str);
// 	顯示全部店家 按company_id 正序 
	List<CompanyVO> findAllCompany();
//	顯示特定店家的資訊
	CompanyVO findCompanyByComId(Integer company_id);

//	圖片
//	查詢特定商品編號的第?張圖片 變數為product_des_id = ? / limit = ? ,1 (?是第1張圖片)
    public ProductImgBO getPic(Integer product_id ,Integer num_pic);
//	查詢特定商品編號的第一個商品明細編號的第一張圖片
    public ProductImgBO getProDesFirstPic(Integer product_id);
//	查詢特定商品明細編號的全部圖片 按product_img_id 正序
//  public List<ProductImgBO> getAllProDesPic(Integer product_des_id);
//	查詢特定商品編號的全部圖片 按product_img_id 正序
    public List<ProductImgBO> getAllProPic(Integer product_id);
    
//  查詢特定會員的WishlistProduct list
    public List<WishlistProduct> getWishlistProductsByMemberId(Integer memberId);
    
    
////更新 山山點數 欄位member_points_sum 條件member_id="?" 
//void UpdateMembPointsByMemId(Integer member_id);
////查詢點數 選擇member_points_sum 條件member_id = "?" 
//Member findMembPointsByMemId(Integer member_id);
//  新增 收藏商品 新增列, wishlist_product_id="自動生成"  
	
}

