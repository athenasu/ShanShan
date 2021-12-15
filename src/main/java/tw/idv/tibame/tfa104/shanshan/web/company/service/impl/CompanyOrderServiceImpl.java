package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Autowired 
	private OrderDescriptionDAO orderDesDao;
	
	@Autowired
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
	public List<OrderDescriptionBO> findByOrderId(Integer orderId) {
		return orderDesDao.BOfindByOrderIdNopic(orderId);
	}

	@Override
	public int updateShipNum(Integer shipNumber, Date shipDate, Integer orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Core updateOrderStatusByOrderId(Integer orderStatus, Integer orderId, Core core) {
		int result = orderDao.updateOrderStatsByOrderId(orderStatus, orderId);
		if(result == 1 ) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setMessage("orderStatus update false");
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
			core.setMessage("prodes stock update false");
			return core;
		}
		
	}

	
	
	
	
}
	
	


