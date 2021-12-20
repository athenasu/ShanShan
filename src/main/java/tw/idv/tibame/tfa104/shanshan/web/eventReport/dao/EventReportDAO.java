package tw.idv.tibame.tfa104.shanshan.web.eventReport.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReportDetailBO;

public interface EventReportDAO {

	int addEventReport(EventReport eventreport);

	List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId);

	List<EventReport> selectNew();

	List<EventReport> selectWaiting();

	List<EventReport> selectDone();

	EventReport selectById(Integer eventReportID);

	List<EventReportDetailBO> selectByIdtest(Integer eventReportID);

	Integer updateEventReport(EventReport eventReport);

}
