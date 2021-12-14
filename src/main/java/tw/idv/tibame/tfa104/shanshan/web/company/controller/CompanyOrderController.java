package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyOrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@RestController
@RequestMapping("companyOrder")
public class CompanyOrderController {

	@Autowired
	private CompanyOrderService service;
	
	//單一店家找所有訂單
	@GetMapping("findAllOrdersByComId")
	public List<Order> findAllOrdersByComId(Integer companyId){
		return service.findAllByComId(1);
	}
	
	//單一店家找未出貨訂單、已出貨訂單
	@GetMapping("findByOrderStatus")
	public List<Order> findAllByOrderStatus(Integer orderStatus,Integer companyId){
		return service.findAllByOrderStatus(orderStatus, companyId);
	}

	//查詢特定訂單的訂單明細BO
	@GetMapping("findDesByOrderId")
	public List<OrderDescriptionBO> findDesByOrderId(Integer orderId){
		return service.findByOrderId(orderId);
	}
}
