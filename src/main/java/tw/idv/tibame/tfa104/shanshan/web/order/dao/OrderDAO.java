package tw.idv.tibame.tfa104.shanshan.web.order.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;

public interface OrderDAO {
	// 此介面定義對資料庫的相關存取抽象方法
	void add(Order order);
	void update(Order order);
	void delete(int order_id);
	Order findByPK(int order_id);
	List<Order> getAll();

}
