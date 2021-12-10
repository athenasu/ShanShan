package tw.idv.tibame.tfa104.shanshan.web.eventReport.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;

public interface EventReportService {

	Integer addEventReport(EventReport eventreport);

	List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId);

}
