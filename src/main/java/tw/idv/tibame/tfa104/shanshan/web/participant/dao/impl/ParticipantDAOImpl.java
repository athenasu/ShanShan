package tw.idv.tibame.tfa104.shanshan.web.participant.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.participant.dao.ParticipantDAO;
import tw.idv.tibame.tfa104.shanshan.web.participant.entity.Participant;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addParticipant(Participant participant) {
		Session session = sessionFactory.getCurrentSession();
		session.save(participant);	
		return 1;
	}
	
}
