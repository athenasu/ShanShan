package tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.impl;

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
}
