package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberOrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@RestController
@RequestMapping("memberOrder")
public class MemberOrderController {
	
	@Autowired
	private MemberOrderService service;
	
	@GetMapping("findAllOrdersByMemId")
	public List<Order> findAllByMemId(Integer memberId){ // change back to HttpSession session
//		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.findAllByMemId(memberId);
	}
	
	@GetMapping("findAllOrderDesByMemId")
	public List<OrderDescriptionBO> findAllOrderDesByMemId(Integer memberId, Integer orderId) { // change back to HttpSession session
//		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.findAllOrderDesByMemId(memberId, orderId);
	}

}
