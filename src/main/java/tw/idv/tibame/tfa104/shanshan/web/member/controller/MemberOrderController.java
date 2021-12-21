package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberOrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@RestController
@RequestMapping("memberOrder")
public class MemberOrderController {
	
	@Autowired
	private MemberOrderService service;
	
	@GetMapping("findAllOrdersByMemId")
	public List<Order> findAllOrdersByMemId(HttpSession session){ //HttpSession session
		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.findAllByMemId(memberId);
	}
	
	@GetMapping("findAllOrderDesByMemId")
	public List<OrderDescriptionBO> findAllOrderDesByMemId(HttpSession session, Integer orderId) {
		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.findAllOrderDesByMemId(memberId, orderId);
	}
	
	@PostMapping("updateOrderStatusByOrderId")
	public Core updateOrderStatusByOrderId(@RequestBody Order order, Core core) {
		return service.updateOrderStatusByOrderId(order.getOrder_status(), order.getOrder_id(), core);
	}

}
