package tw.idv.tibame.tfa104.shanshan.web.msgReport.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.msgReport.dao.EventMsgReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.msgReport.entity.msgReport;
import tw.idv.tibame.tfa104.shanshan.web.msgReport.service.EventMsgReportService;

@Service
@Transactional
public class EventMsgReportServiceImpl implements EventMsgReportService{
	private EventMsgReportDAO dao;
	
	@Override
	public Integer addEventMsgReport(msgReport msgReport) {
		return dao.addEventMsgReport(msgReport);
	}
}
