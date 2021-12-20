package tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.EventReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReportDetailBO;

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
	
	@Override
	public List<EventReport> selectNew(){
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
											"FROM event_report "+
											"WHERE case_status = 1", EventReport.class).list();
	}
	
	@Override
	public List<EventReport> selectWaiting(){
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
											"FROM event_report "+
											"WHERE case_status = 0", EventReport.class).list();
	}
	
	@Override
	public List<EventReport> selectDone(){
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
											"FROM event_report "+
											"WHERE case_status = 2", EventReport.class).list();
	}
	
	@Override
	public EventReport selectById(Integer eventReportID) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(EventReport.class, eventReportID);
	}
	
	@Override
	public List<EventReportDetailBO> selectByIdtest(Integer eventReportID) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
											"a.event_report_id as eventReportID, "+
											"a.member_id as memberId, "+
											"a.event_id as eventId, "+
											"a.report_reason as reportReason, "+
											"a.report_date as reportDate, "+
											"a.case_done as caseDone, "+
											"a.case_status as caseStatus, "+
											"b.member_name as memberName, "+
											"b.member_Username as memberUsername, "+
											"c.event_content as eventContent "+
											"FROM event_report as a "+
											"JOIN member as b "+
											"ON a.member_id = b.member_id "+
											"JOIN event as c "+
											"ON a.event_id = c.event_id "+
											"WHERE case_status = 1 AND event_report_id = :eventReportID", EventReportDetailBO.class).setParameter("eventReportID", eventReportID).list();
	}
	
	@Override
	public Integer updateEventReport(EventReport eventReport) {
		Session session = sessionFactory.getCurrentSession();
		EventReport tempEventReport = session.get(EventReport.class, eventReport.getEventReportID());
		
		final Integer caseStatus = eventReport.getCaseStatus();
		if(caseStatus != null) {
			tempEventReport.setCaseStatus(caseStatus);
		}
		
		final Timestamp caseDone = eventReport.getCaseDone();
		if(caseDone != null) {
			tempEventReport.setCaseDone(caseDone);
		}
			
		session.update(tempEventReport);
		return 1;
	}
}
