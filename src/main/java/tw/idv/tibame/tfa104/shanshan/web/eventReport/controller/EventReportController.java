package tw.idv.tibame.tfa104.shanshan.web.eventReport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReportDetailBO;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.service.EventReportService;

@RestController
@RequestMapping("eventReport")
@SessionAttributes({ "eventReport" })
public class EventReportController {
	@Autowired
	private EventReportService eventReportService;
	
	@CrossOrigin
	@PostMapping(path = "addEventReport", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addEventReport(@RequestBody EventReport eventreport){
		return eventReportService.addEventReport(eventreport);
	}
	
	@CrossOrigin
	@GetMapping("selectEventReportByMemberId")
	public List<EventReport> selectEventReportByMemberId(Integer memberId, Integer eventId){
		final List<EventReport> eventListByMemberId = eventReportService.selectEventReportByMemberId(memberId, eventId);
		return eventListByMemberId;
	}
	
	@CrossOrigin
	@GetMapping("selectNew")
	public List<EventReport> selectNew(){
		final List<EventReport> newCases = eventReportService.selectNew();
		return newCases;
	}
	
	@CrossOrigin
	@GetMapping("selectDone")
	public List<EventReport> selectDone(){
		final List<EventReport> doneCases = eventReportService.selectDone();
		return doneCases;
	}
	
	@CrossOrigin
	@GetMapping("selectById")
	public EventReport selectById(Integer eventReportID){
		final EventReport selectById = eventReportService.selectById(eventReportID);
		return selectById;
	}
	
	@CrossOrigin
	@GetMapping("selectByIdtest")
	public List<EventReportDetailBO> selectByIdtest(Integer eventReportID){
		final List<EventReportDetailBO> selectByIdtest = eventReportService.selectByIdtest(eventReportID);
		return selectByIdtest;
	}
	
	@CrossOrigin
	@PutMapping(path="updateEventReport", consumes = { MediaType.APPLICATION_JSON_VALUE })
		public Integer updateEventReport(@RequestBody EventReport eventReport) {
			return eventReportService.updateEventReport(eventReport);
		}
	
}
