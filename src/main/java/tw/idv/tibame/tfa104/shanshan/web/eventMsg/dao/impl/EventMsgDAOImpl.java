package tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao.EventMsgDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsgMemberBO;

@Repository
public class EventMsgDAOImpl implements EventMsgDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addEventMsg(EventMsg eventMsg) {
		Session session = sessionFactory.getCurrentSession();
		session.save(eventMsg);	
		return 1;
	}
	
	@Override
	public List<EventMsgMemberBO> eventMsgList(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();	
		return session.createNativeQuery("SELECT "+
												"a.event_msg_id as eventMsgId, "+
												"a.event_id as eventId, "+
												"a.member_id as memberId, "+
												"b.member_profile_pic as memberProfilePic, "+
												"b.member_name as memberName, "+
												"a.msg_content as msgContent, "+
												"a.msg_date as msgDate "+
										  "FROM event_msg a "+
										  "JOIN member b "+
										  "ON a.member_id = b.member_id "+
										  "WHERE a.event_id = :eventId and a.msg_status = 1 "+
										  "ORDER BY a.event_msg_id desc", EventMsgMemberBO.class)
							.setParameter("eventId", eventId).list();
	}
}
