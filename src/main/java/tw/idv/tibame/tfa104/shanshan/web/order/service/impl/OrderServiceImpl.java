package tw.idv.tibame.tfa104.shanshan.web.order.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.impl.OrderDAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.order.service.OrderService;

public class OrderServiceImpl implements OrderService{

	OrderDAO dao = new OrderDAOImpl();


//	新增 訂單 成功返回1，失敗返回0

	@Override
	public int add(Order order) {
		return dao.add(order);
	}

//	查詢 特定會員的最新一張訂單(用來 顯示結帳結果)
	@Override
	public Order findLatestByMemId(Integer member_id) {
		return dao.findLatestByMemId(member_id);
	}
	
	@Override
	public int updateShipNumByOrderId(Integer ship_number, Integer order_id) {
		return 0;
	}

	@Override
	public int updatePayStatsByOrderId(Integer payment_status, Integer order_id) {
		return 0;
	}

	@Override
	public int updateOrderStatsByOrderId(Integer order_status, Integer order_id) {
		return 0;
	}

	@Override
	public Order findByOrderId(Integer order_id) {
		return dao.findByOrderId(order_id);
	}

	@Override
	public List<Order> findAll() {
		
		return dao.findAll();
	}

	@Override
	public List<Order> findAllByComIdOrderStatus(Integer order_status, Integer company_id) {
		return dao.findAllByComIdOrderStatus(order_status, company_id);
	}

	@Override
	public List<Order> findAllByMemIdOrderStatus(Integer order_status, Integer member_id) {
		return dao.findAllByMemIdOrderStatus(order_status,member_id);
	}

	@Override
	public List<Order> findByLastest(Integer sequence) {
		return dao.findByLastest(sequence);
	}

	@Override
	public List<Order> findAllByComId(Integer company_id) {
		return dao.findAllByComId(company_id) ;
	}

	@Override
	public List<Order> findAllByMemId(Integer member_id) {
		return dao.findAllByMemId(member_id);
	}

	@Override
	public List<Order> findAllByMemIdUsePointNotZero(Integer member_id) {
		return dao.findAllByMemIdUsePointNotZero(member_id);
	}

	@Override
	public List<Order> findAllByComIdLikeInt(Integer company_id, String keyword) {
		return dao.findAllByComIdLikeInt(company_id, keyword);
	}

	@Override
	public List<Order> findAllByDateRangeComId(Integer company_id, String from_date, String to_date) {
		return dao.findAllByDateRangeComId(company_id,from_date,to_date);
	}

	@Override
	public List<Order> findAllByPayStatus(Integer payment_status) {
		return dao.findAllByPayStatus(payment_status);
	}

	@Override
	public List<Order> findAllByDateRangePayStatus(String from_date, String to_date, Integer payment_status) {
		return dao.findAllByDateRangePayStatus(from_date,to_date,payment_status);
	}

	@Override
	public List<Order> findAllByDateRangeComIdPayStatus(Integer company_id, Integer payment_status, String from_date,
			String to_date) {
		return dao.findAllByDateRangeComIdPayStatus(company_id,payment_status,from_date, to_date);
	}

	
	
	
}
