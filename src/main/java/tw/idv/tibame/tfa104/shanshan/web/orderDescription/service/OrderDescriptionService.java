package tw.idv.tibame.tfa104.shanshan.web.orderDescription.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

public interface OrderDescriptionService {

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
//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片，拿掉一些店家後台用的資料)
	List<OrderDescriptionBO> BOfindByOrderIdForMemCentr(Integer order_id);
//	查詢 特定會員的訂單+訂單明細BO 按訂單明細編號 正序 
	List<OrderDescriptionBO> BOfindByMemIdForMembCentr(Integer member_id);
}


