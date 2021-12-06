package tw.idv.tibame.tfa104.shanshan.web.participant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.participant.dao.ParticipantDAO;
import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;
import tw.idv.tibame.tfa104.shanshan.web.participant.service.ParticipantService;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService{
	@Autowired
	private ParticipantDAO dao;
	
	@Override
	public Integer addParticipant(Participant participant) {
		return dao.addParticipant(participant);		
	}
}
