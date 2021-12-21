package tw.idv.tibame.tfa104.shanshan;

import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.impl.OrderDAOImpl;

public class XXXTest {
	
	public static void main(String[] args) {
		OrderDAO test = new OrderDAOImpl();
		int result = test.updateOrderStatsByOrderId(2, 40);
		System.out.println(result);
	}
}
