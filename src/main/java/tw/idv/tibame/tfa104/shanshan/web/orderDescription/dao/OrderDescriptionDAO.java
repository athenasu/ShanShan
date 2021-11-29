package tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;


public interface OrderDescriptionDAO {
//	新增 訂單明細 成功返回1，失敗返回0
	int add(OrderDescription order_description);
//	更新 訂單明細全部欄位 成功返回1，失敗返回0
	int update(OrderDescription order_description);
//	刪除 訂單明細 成功返回1，失敗返回0
	int delete(Integer order_des_id);
//	查詢 訂單明細 BY PK
	OrderDescription findByOrderDesId(Integer order_des_id);
//	查詢 全部訂單明細 按order_des_id 倒序
	List<OrderDescription> findAll();
//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	OrderDescription findByOrderId(Integer order_id);
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (圖片是pro_des第一張圖)
	List<OrderDescriptionBO> BOfindByOrderId(Integer order_id);
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片)
	List<OrderDescriptionBO> BOfindByOrderIdNopic(Integer order_id);
//	回傳10個 ProductBO , 熱門商品 (10個)  按總銷售數 正序
	List<ProductBO> findpopular10();
	
	
	
}

