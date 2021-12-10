package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberEventService;
import tw.idv.tibame.tfa104.shanshan.web.participant.dao.ParticipantDAO;


@Service
@Transactional
public class MemberEventServiceImpl implements MemberEventService {
	
	@Autowired
	private ParticipantDAO partDao;
	
	@Autowired
	private EventDAO eventDao;

	@Override
	public Boolean deleteParticipation(Integer memberId, Integer eventId) {
		int result = partDao.deleteParticipantByMemIdEventId(memberId, eventId);
		if (result >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Integer cancelEvent(Integer eventId) {
		return eventDao.deleteEventById(eventId);
	}
	
	@Override
	public Integer confirmEvent(Event event) {
		return eventDao.updateEventById(event);
	}
	
}
