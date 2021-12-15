package tw.idv.tibame.tfa104.shanshan.web.company.service;

import java.util.Date;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

public interface CompanyOrderService {
	//查詢單一店家所有訂單
	List<Order> findAllByComId(Integer companyId);
	
	//查單一店家未出貨訂單、已出貨訂單
	List<Order> findAllByOrderStatus(Integer orderStatus,Integer companyId);
	
	//查詢特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片)
    List<OrderDescriptionBO> findByOrderId(Integer orderId);
	
	//更新特定訂單的貨運單號及出貨日(9開頭,六位數字) 成功返回1，失敗返回0
    public int updateShipNum (Integer shipNumber,Date shipDate,Integer orderId);
	
    //更新訂單狀態01訂單成立->02已出貨
    public Core updateOrderStatusByOrderId(Integer orderStatus, Integer orderId, Core core);
    	
    //出貨更新商品庫存數
    public Core updateProductDesStock(Integer prodesId, Integer prodesStock, Core core);
	//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	// OrderDescription findByOrderId(Integer order_id);
	

}
