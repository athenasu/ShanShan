package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyOrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@Service
@Transactional
public class CompanyOrderServiceImpl implements CompanyOrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired 
	private OrderDescriptionDAO orderDesDao;
	
	
	@Override
	public List<Order> findAllByComId(Integer companyId) {
		return orderDao.findAllByComId(companyId);
	}

	@Override
	public List<Order> findAllByOrderStatus(Integer orderStatus, Integer companyId) {
		return orderDao.findAllByComIdOrderStatus(orderStatus,companyId);
	}
	
	@Override
	public List<OrderDescriptionBO> findByOrderId(Integer orderId) {
		return orderDesDao.BOfindByOrderIdNopic(orderId);
	}

}
	
	


