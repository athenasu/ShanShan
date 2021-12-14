package tw.idv.tibame.tfa104.shanshan.web.company.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

public interface CompanyOrderService {
	//查詢單一店家所有訂單
	List<Order> findAllByComId(Integer companyId);
	
	//查單一店家未出貨訂單、已出貨訂單
	List<Order> findAllByOrderStatus(Integer orderStatus,Integer companyId);
	
	//查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片)
    List<OrderDescriptionBO> findByOrderId(Integer orderId);
	
    
	//	更新 特定訂單的貨運單號(9開頭,六位數字) 成功返回1，失敗返回0
	//int updateShipNumByOrderId(Integer ship_number, Integer order_id);
	
	
	//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	// OrderDescription findByOrderId(Integer order_id);
	

}
