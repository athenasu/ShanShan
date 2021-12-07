package tw.idv.tibame.tfa104.shanshan.web.participant.dao;

import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;

public interface ParticipantDAO {

	int addParticipant(Participant participant);

	Integer updateParticipant(Participant participant);

}
