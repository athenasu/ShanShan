package tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.EventReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;

@Repository
public class EventReportDAOImpl implements EventReportDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addEventReport(EventReport eventreport) {
		Session session = sessionFactory.getCurrentSession();
		session.save(eventreport);	
		return 1;
	}
	
	@Override
	public List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
											"FROM event_report "+
											"WHERE member_id = :memberId AND event_id = :eventId", EventReport.class)
											.setParameter("memberId", memberId)
											.setParameter("eventId", eventId).list();
	}
}
