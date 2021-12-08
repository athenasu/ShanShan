package tw.idv.tibame.tfa104.shanshan.web.participant.dao.impl;

import java.util.List;

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
	
	@Override
	public Integer updateParticipant (Participant participant) {
		Session session = sessionFactory.getCurrentSession();
//		Participant tempParticipant = session.get(Participant.class, participant.getPartId());
		Participant tempParticipant = new Participant();
		
		final Integer partId = participant.getPartId();
		if(partId != null) {
			tempParticipant.setPartId(partId);
		}
		
		session.update(participant);
		return 1;
	}
	
	@Override
	public List<Participant> selectParticipantByMemberId(Integer memberId, Integer eventId){
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
											"FROM Participant "+
											"WHERE member_id = :memberId AND event_id = :eventId", Participant.class)
										.setParameter("memberId", memberId)
										.setParameter("eventId", eventId).list();
	}
}
