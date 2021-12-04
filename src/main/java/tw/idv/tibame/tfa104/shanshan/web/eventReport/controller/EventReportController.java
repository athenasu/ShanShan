package tw.idv.tibame.tfa104.shanshan.web.eventReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import tw.idv.tibame.tfa104.shanshan.web.eventReport.entity.EventReport;
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
}
