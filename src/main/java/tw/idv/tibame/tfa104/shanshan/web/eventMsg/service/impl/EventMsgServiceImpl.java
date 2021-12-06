package tw.idv.tibame.tfa104.shanshan.web.eventMsg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao.EventMsgDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsgMemberBO;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.service.EventMsgService;

@Service
@Transactional
public class EventMsgServiceImpl implements EventMsgService{
	@Autowired
	private EventMsgDAO dao;
	
	@Override
	public Integer addEventMsg(EventMsg eventMsg) {
		return dao.addEventMsg(eventMsg);		
	}
	
	@Override
	public List<EventMsgMemberBO> eventMsgList(Integer eventId) {
		return dao.eventMsgList(eventId);		
	}
}
