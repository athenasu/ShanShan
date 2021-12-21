package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyOrderService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;

@Service
@Transactional
public class CompanyOrderServiceImpl implements CompanyOrderService {

	@Autowired
	private OrderDAO orderDao;
	private OrderDescriptionDAO orderDesDao;
	private ProductDesDAOHibernate proDesDao;
	
	
	
	@Override
	public List<Order> findAllByComId(Integer companyId) {
		return orderDao.findAllByComId(companyId);
	}

	@Override
	public List<Order> findAllByOrderStatus(Integer orderStatus, Integer companyId) {
		return orderDao.findAllByComIdOrderStatus(orderStatus,companyId);
	}
	
	@Override
	public List<Order> findAllShippedByComId(Integer companyId) {
		return orderDao.findAllShippedByComId(companyId);
	}
	
	@Override
	public List<OrderDescriptionBO> findByOrderId(Integer orderId) {
		return orderDesDao.BOfindByOrderIdNopic(orderId);
	}

	@Override
	public Core updateShipNum(String shipNumber,Date shipDate, Integer orderId,Core core) {
		int result = orderDao.updateShipNumDateByOrderId(shipNumber, shipDate, orderId);
		if(result == 1 ) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setSuccessful(false);
			return core;
		}
	}

	@Override
	public Core updateOrderStatusByOrderId(Integer orderStatus, Integer orderId, Core core) {
		int result = orderDao.updateOrderStatsByOrderId(orderStatus, orderId);
		if(result == 1 ) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setSuccessful(false);
			return core;
		}
	}

	@Override
	public Core updateProductDesStock(Integer prodesId, Integer prodesStock, Core core) {
		int result = proDesDao.updateProdesStock(prodesId, prodesStock);
		if(result == 1) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setSuccessful(false);
			return core;
		}
		
	}
}

	

	
	
	
	
 
	
	


