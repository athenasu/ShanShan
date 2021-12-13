package tw.idv.tibame.tfa104.shanshan.web.order.service.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.impl.OrderDAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.order.service.OrderService;

public class OrderServiceImpl implements OrderService{

	OrderDAO dao = new OrderDAOImpl();


//	新增 訂單 成功返回1，失敗返回0

	@Override
	public int add(Order order) {
		// TODO Auto-generated method stub
		return dao.add(order);
	}

//	查詢 特定會員的最新一張訂單(用來 顯示結帳結果)
	@Override
	public Order findLatestByMemId(Integer member_id) {
		return dao.findLatestByMemId(member_id);
	}
	
	@Override
	public int updateShipNumByOrderId(Integer ship_number, Integer order_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePayStatsByOrderId(Integer payment_status, Integer order_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrderStatsByOrderId(Integer order_status, Integer order_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findByOrderId(Integer order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByComIdOrderStatus(Integer order_status, Integer company_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByMemIdOrderStatus(Integer order_status, Integer member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByLastest(Integer sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByComId(Integer company_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByMemId(Integer member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByMemIdUsePointNotZero(Integer member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByComIdLikeInt(Integer company_id, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByDateRangeComId(Integer company_id, String from_date, String to_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByPayStatus(Integer payment_status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByDateRangePayStatus(String from_date, String to_date, Integer payment_status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAllByDateRangeComIdPayStatus(Integer company_id, Integer payment_status, String from_date,
			String to_date) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
