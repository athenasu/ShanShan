package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
<<<<<<< HEAD
	@Autowired
	private OrderDAO orderDao;
	
	public List<Order> findAllByMemId(Integer memberId) {
		return orderDao.findAllByMemId(memberId);
	}
	
	public List<OrderDescriptionBO> findAllOrderDesByMemId(Integer memberId, Integer orderId){
		return orderDesDao.BOfindByMemIdForMembCentr(memberId, orderId);
=======
	public List<OrderDescriptionBO> findAllOrdersByMemId(Integer memberId){
		return null;
>>>>>>> 599d345ec811b333e959738342318a33ac401f00
	}

}
