package tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.dao.EventMsgDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;

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
}
