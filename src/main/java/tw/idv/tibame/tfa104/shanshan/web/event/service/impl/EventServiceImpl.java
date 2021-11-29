package tw.idv.tibame.tfa104.shanshan.web.event.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;


@Service
@Transactional
public class EventServiceImpl implements EventService{
	@Autowired
	private EventDAO dao;

	@Override
	public int submitEvent(Event event) {
		return dao.addEvent(event);		
	}

	@Override
	public Event updateEvent(Event event) {
		return dao.updateEventById(event);
	}

	@Override
	public Event deleteEvent(Event event) {
		return event;
	}

	@Override
	public Event findEventByEventId(Integer eventId) {
		return dao.selectByEventId(eventId);
	}

	@Override
	public List<Event> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public List<Object[]> findEventByDistrict(Integer mountainDistrict){
		return dao.selectByDistrict(mountainDistrict);
	}
	
	@Override
	public List<Object[]> findEventByMemberId(Integer memberId) {
		return  dao.selectByMemberId(memberId);
	}

	@Override
	public List<Object[]> popularEvents() {
		return dao.popularEvents();
	}

	@Override
	public List<Object[]> onGoingEvents() {
		return dao.onGoingEvents();
	}

	@Override
	public List<Object[]> eventList() {
		return dao.eventList();
	}

	@Override
	public List<Object[]> parEventByMember(Integer memberId) {
		return dao.parEventByMember(memberId);
	}
}
