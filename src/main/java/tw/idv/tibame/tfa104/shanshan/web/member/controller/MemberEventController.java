package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberEventService;
import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;

@RestController
@RequestMapping("memberEvent")
public class MemberEventController {
	
	@Autowired
	private MemberEventService service;
	
	@PostMapping("cancelEvent")
	public Integer cancelEvent(@RequestBody Event event) {
		return service.cancelEvent(event);
	}
	
	@PostMapping("confirmEvent")
	public Integer confirmEvent(@RequestBody Event event) {
		return service.confirmEvent(event);
	}
	
	@PostMapping("deleteParticipation")
	public Core deleteParticipation(@RequestBody Participant participant) {// need to add HttpSession into this
		Core core = new Core();
		boolean result = service.deleteParticipation(1, participant.getEventId()); //participant.getMemberId()--> use session
		if (result) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}

}
