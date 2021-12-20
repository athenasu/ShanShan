package tw.idv.tibame.tfa104.shanshan.web.articleReport.service;

import java.sql.Date;

public interface ReportService {
	
	public Integer changeStatus(Integer articleReportId, Integer reportStatus, Date caseDone);

}
