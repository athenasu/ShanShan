package tw.idv.tibame.tfa104.shanshan.web.eventMsg.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsgMemberBO;

public interface EventMsgService {

	Integer addEventMsg(EventMsg eventMsg);

	List<EventMsgMemberBO> eventMsgList(Integer eventId);

}
