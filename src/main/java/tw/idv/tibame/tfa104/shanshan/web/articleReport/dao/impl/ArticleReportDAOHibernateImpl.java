package tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.impl;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.ArticleReportDAOHibernate;

@Repository
public class ArticleReportDAOHibernateImpl implements ArticleReportDAOHibernate {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer changeStatus(Integer articleReportId, Integer reportStatus, Date caseDone) {
//		UPDATE article_report 
//		SET article_report_status = 1, case_done = 123
//		WHERE article_report_id = 1;
		Session session = sessionFactory.getCurrentSession();
		int result = session.createNativeQuery("UPDATE article_report \n" + 
				"SET article_report_status = :reportStatus, case_done = :caseDone" + 
				"WHERE article_report_id = :articleReportId")
				.setParameter("reportStatus", reportStatus)
				.setParameter("caseDone", caseDone)
				.setParameter("articleReportId", articleReportId)
				.executeUpdate();
		return result;
	}

}
