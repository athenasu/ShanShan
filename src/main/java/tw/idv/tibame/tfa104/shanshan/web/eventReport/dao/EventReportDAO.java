package tw.idv.tibame.tfa104.shanshan.web.eventReport.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;

public interface EventReportDAO {

	int addEventReport(EventReport eventreport);

	List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId);

}
