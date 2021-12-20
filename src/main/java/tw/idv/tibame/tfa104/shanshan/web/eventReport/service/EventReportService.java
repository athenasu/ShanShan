package tw.idv.tibame.tfa104.shanshan.web.eventReport.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReportDetailBO;

public interface EventReportService {

	Integer addEventReport(EventReport eventreport);

	List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId);

	List<EventReport> selectNew();
	
	List<EventReport> selectDone();
	
	EventReport selectById(Integer eventReportID);

	List<EventReportDetailBO> selectByIdtest(Integer eventReportID);
	
	Integer updateEventReport(EventReport eventReport);
}
