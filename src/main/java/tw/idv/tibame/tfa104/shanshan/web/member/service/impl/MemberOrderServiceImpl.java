package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberOrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.dao.OrderDAO;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@Service
@Transactional
public class MemberOrderServiceImpl implements MemberOrderService {
	
	@Autowired
	private OrderDescriptionDAO orderDesDao;
	
	@Autowired
	private OrderDAO orderDao;
	
	@Override
	public List<Order> findAllByMemId(Integer memberId) {
		return orderDao.findAllByMemId(memberId);
	}
	
	@Override
	public List<OrderDescriptionBO> findAllOrderDesByMemId(Integer memberId, Integer orderId){
		return orderDesDao.BOfindByMemIdForMembCentr(memberId, orderId);
	}
	
	@Override
	public Core updateOrderStatsByOrderId(Integer orderStatus, Integer orderId, Core core) {
		int result = orderDao.updateOrderStatsByOrderId(orderStatus, orderId);
		if (result ==1) {
			core.setSuccessful(true);
			return core;
		} else {
			core.setSuccessful(false);
			return core;
		}
	}
	
}
