package tw.idv.tibame.tfa104.shanshan.web.eventReport.service.impl;

import java.util.List;

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
	
	@Override
	public List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId){
		return dao.selectEventReportByMemberId(memberId, eventId);
	}
	
	@Override
	public List<EventReport> selectNew(){
		return dao.selectNew();
	}
	
	public List<EventReport> selectDone(){
		return dao.selectDone();
	}
}
