package tw.idv.tibame.tfa104.shanshan.web.eventReport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.dao.EventReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.service.EventReportService;

@Service
@Transactional
public class EventReportServiceImpl implements EventReportService{
	@Autowired
	private EventReportDAO dao;
	
	@Override
	public Integer addEventReport(EventReport eventreport) {
		return dao.addEventReport(eventreport);		
	}
}
