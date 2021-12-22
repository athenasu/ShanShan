package tw.idv.tibame.tfa104.shanshan.web.msgReport.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.msgReport.dao.EventMsgReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.msgReport.entity.msgReport;

@Repository
public class EventMsgReportDAOImpl implements EventMsgReportDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addEventMsgReport(msgReport msgReport) {
		Session session = sessionFactory.getCurrentSession();
		session.save(msgReport);	
		return 1;
	}
}
