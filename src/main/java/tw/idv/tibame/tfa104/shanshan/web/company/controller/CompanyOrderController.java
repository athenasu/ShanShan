package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyOrderService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
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
	
	//提供貨運單號(9開頭,六位數字)確認出貨
	@PostMapping(path = "updateShip" , consumes = { MediaType.APPLICATION_JSON_VALUE })
	public int updateShip(Integer shipNumber,Date shipDate ,Integer orderId) {
		return service.updateShipNum(shipNumber,shipDate,orderId);
	}
	
	//更新訂單狀態01訂單成立->02已出貨
	@PostMapping("updateOrderStatus")
	public Core updateOrderStatusByOrderId(Integer orderStatus, Integer orderId, Core core) {
		System.out.println("in update orderStatus");
		Core core1 = service.updateOrderStatusByOrderId(orderStatus, orderId, core);
		return core1;
	}
	
	//訂單出貨後更新商品庫存
	@PostMapping("updateProDesStock")
	public Core updateProductDesStock(Integer prodesId, Integer prodesStock, Core core) {
		return service.updateProductDesStock(prodesId, prodesStock, core);
	}
}
