package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyOrderService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;

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
	//單一店家找未出貨訂單
	@GetMapping("findByOrderStatus")
	public List<Order> findAllByOrderStatus(Integer orderStatus,Integer companyId){
		return service.findAllByOrderStatus(orderStatus, companyId);
	}

	//查詢單一店家已出貨訂單（非狀態0取消、1訂單成立、6退貨)
	@GetMapping("findAllShipped")
	public List<Order> findAllShippedByComId(Integer companyId){
		return service.findAllShippedByComId(companyId);
	}
	//查詢特定訂單的訂單明細BO
	@GetMapping("findDesByOrderId")
	public List<OrderDescriptionBO> findDesByOrderId(Integer orderId){
		return service.findByOrderId(orderId);
	}
	
	//提供貨運單號(9開頭,六位數字)確認出貨
	@PostMapping("updateShip")
	public Core updateShip(@RequestBody Order order,Core core) {
		System.out.println("in update ShipNum");
		Core core1 = service.updateShipNum(order.getShip_number(),order.getOrder_shipped_date(),order.getOrder_id(),core);
		System.out.println(order.getOrder_shipped_date());
		return core1;
	}
	
	//更新訂單狀態01訂單成立->02已出貨
	@PostMapping("updateOrderStatus")
	public Core updateOrderStatusByOrderId(@RequestBody Order order, Core core) {
		System.out.println("in update orderStatus");
		Core core2 = service.updateOrderStatusByOrderId(order.getOrder_status(),order.getOrder_id(), core);
		return core2;
	}
	
	//訂單出貨後更新商品庫存(庫存減少)
	@PostMapping("updateProDesStock")
	public Core updateProductDesStock(@RequestBody ProductDesVO prodes, Core core) {
		System.out.println("in update prodes");
		Core core3 = service.updateProductDesStock(prodes.getProductDesId(), prodes.getProductStock(), core);
		return core3;
	}
	
	
	
}
