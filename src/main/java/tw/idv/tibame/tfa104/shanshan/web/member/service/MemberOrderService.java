package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

public interface MemberOrderService {
	
	List<Order> findAllByMemId(Integer memberId);
	List<OrderDescriptionBO> findAllOrderDesByMemId(Integer memberId, Integer orderId);

}
