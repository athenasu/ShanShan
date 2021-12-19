package tw.idv.tibame.tfa104.shanshan.web.eventMsg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsg;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity.EventMsgMemberBO;
import tw.idv.tibame.tfa104.shanshan.web.eventMsg.service.EventMsgService;

@RestController
@RequestMapping("eventMsg")
@SessionAttributes({ "eventMsg" })
public class EventMsgController {
	@Autowired
	private EventMsgService eventMsgService;
	
	@CrossOrigin
	@PostMapping(path = "addEventMsg", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addEventMsg(@RequestBody EventMsg eventMsg){
		return eventMsgService.addEventMsg(eventMsg);
	}
	
	@CrossOrigin
	@GetMapping("eventMsgList")
	public List<EventMsgMemberBO> eventMsgList(Integer eventId) {
		final List<EventMsgMemberBO> eventMsgList = eventMsgService.eventMsgList(eventId);		
		return eventMsgList;
	}
}
