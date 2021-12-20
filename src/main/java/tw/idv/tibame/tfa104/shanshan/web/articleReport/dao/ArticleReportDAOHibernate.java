package tw.idv.tibame.tfa104.shanshan.web.articleReport.dao;

import java.sql.Date;

public interface ArticleReportDAOHibernate {
	
	public Integer changeStatus(Integer articleReportId, Integer reportStatus, Date caseDone);

}
