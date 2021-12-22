package tw.idv.tibame.tfa104.shanshan.web.msgReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import tw.idv.tibame.tfa104.shanshan.web.msgReport.entity.msgReport;
import tw.idv.tibame.tfa104.shanshan.web.msgReport.service.EventMsgReportService;

@RestController
@RequestMapping("msgReport")
@SessionAttributes({ "msgReport" })
public class EventMsgReportController {
	@Autowired
	private EventMsgReportService eventMsgReportService;
	
	@CrossOrigin
	@PostMapping(path = "addEventMsgReport", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addEventMsgReport(@RequestBody msgReport msgReport) {
		return eventMsgReportService.addEventMsgReport(msgReport);
	}
}
