package tw.idv.tibame.tfa104.shanshan.web.participant.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;


public interface ParticipantService {

	Integer addParticipant(Participant participant);

	Integer updateParticipant(Participant participant);

	List<Participant> selectParticipantByMemberId(Integer memberId, Integer eventId);

}
