package tw.idv.tibame.tfa104.shanshan.web.order.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;

public interface OrderService {
//	更新 特定訂單的貨運單號(9開頭,六位數字) 成功返回1，失敗返回0
	int updateShipNumByOrderId(Integer ship_number, Integer order_id);
//	更新 特定訂單的撥款狀態 成功返回1，失敗返回0
	int updatePayStatsByOrderId(Integer payment_status, Integer order_id);
//	更新 特定訂單的訂單狀態 成功返回1，失敗返回0
	int updateOrderStatsByOrderId(Integer order_status,Integer order_id);
//	查詢  訂單  BY PK
	Order findByOrderId(Integer order_id);
//	查詢 全部訂單
	List<Order> findAll();
//	查詢 特定店家的特定訂單狀態的訂單 按order id 倒序
	List<Order> findAllByComIdOrderStatus(Integer order_status, Integer company_id);
//	查詢 特定會員的特定訂單狀態的訂單 按order id 倒序 
	List<Order> findAllByMemIdOrderStatus(Integer order_status, Integer member_id);
//	查詢 最新的訂單 參數為多少筆 按order id 倒序
	List<Order> findByLastest(Integer sequence);
//	查詢 特定店家的訂單 按order id 倒序
	List<Order> findAllByComId(Integer company_id);
//	查詢 特定會員的訂單 按order id 倒序
	List<Order> findAllByMemId(Integer member_id);
//	查詢 特定會員 使用點數不為零 的訂單 按order id 倒序
	List<Order> findAllByMemIdUsePointNotZero(Integer member_id);
//	查詢 特定店家的訂單號碼 BY LIKE %?% 按order id 正序
	List<Order> findAllByComIdLikeInt(Integer company_id, String keyword);
//	查詢 特定日期範圍 特定店家的訂單  按order id 倒序
	List<Order> findAllByDateRangeComId(Integer company_id, String from_date, String to_date);
//	查詢 所有訂單的撥款狀態 按order id 倒序
	List<Order> findAllByPayStatus(Integer payment_status);
//	查詢 特定日期範圍的所有訂單的撥款狀態  按order id 倒序
	List<Order> findAllByDateRangePayStatus(String from_date, String to_date,Integer payment_status);
//	查詢 特定日期範圍的特定店家的訂單撥款狀態  按order id 倒序
	List<Order> findAllByDateRangeComIdPayStatus(Integer company_id,Integer payment_status, String from_date, String to_date);


}
