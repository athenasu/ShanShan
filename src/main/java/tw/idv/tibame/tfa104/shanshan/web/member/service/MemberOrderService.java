package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

public interface MemberOrderService {
	
	// select: find all orders by memberId
	List<Order> findAllByMemId(Integer memberId);
	// select: find all order descriptions by memberId and orderId
	List<OrderDescriptionBO> findAllOrderDesByMemId(Integer memberId, Integer orderId);
	// update: order status
	Core updateOrderStatsByOrderId(Integer orderStatus, Integer orderId, Core core);

}
