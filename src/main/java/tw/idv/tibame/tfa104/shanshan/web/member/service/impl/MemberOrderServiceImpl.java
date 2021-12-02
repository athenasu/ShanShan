package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberOrderService;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;

@Service
@Transactional
public class MemberOrderServiceImpl implements MemberOrderService {
	
	@Autowired
	private OrderDescriptionDAO dao;
	
	public List<OrderDescriptionBO> findAllOrdersByMemId(Integer memberId){
		return dao.BOfindByMemIdForMembCentr(memberId);
	}

}
