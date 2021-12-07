package tw.idv.tibame.tfa104.shanshan.web.participant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;
import tw.idv.tibame.tfa104.shanshan.web.participant.service.ParticipantService;

@RestController
@RequestMapping("participant")
@SessionAttributes({ "participant" })
public class ParticipantController {
	@Autowired
	private ParticipantService participantService;
	
	@CrossOrigin
	@PostMapping(path = "addParticipant", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addParticipant(@RequestBody Participant participant) {
		return participantService.addParticipant(participant);
	}
	
	@CrossOrigin
	@PostMapping(path = "updateParticipant", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer updateParticipant(@RequestBody Participant participant) {
		return participantService.updateParticipant(participant);
	}
}
