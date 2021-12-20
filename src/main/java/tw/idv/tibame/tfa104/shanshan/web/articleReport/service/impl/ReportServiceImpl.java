package tw.idv.tibame.tfa104.shanshan.web.articleReport.service.impl;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.ArticleReportDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ArticleReportDAOHibernate dao;
	
	@Override
	public Integer changeStatus(Integer articleReportId, Integer reportStatus, Date caseDone) {
		int result = dao.changeStatus(articleReportId, reportStatus, caseDone);
		return result;
	}

}
