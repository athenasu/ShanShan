package tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsgMemberBO;

public interface EventMsgDAO {

	int addEventMsg(EventMsg eventMsg);

	List<EventMsgMemberBO> eventMsgList(Integer eventId);

}
