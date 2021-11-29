package tw.idv.tibame.tfa104.shanshan.web.event.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;


public interface EventService {
	int submitEvent(Event event);
	Event updateEvent(Event event);
	Event deleteEvent(Event event); //change eventStatus
	Event findEventByEventId(Integer eventId);
	List<Event> selectAll();
	List<Object[]> eventList();
	List<Object[]> findEventByDistrict(Integer mountainDistrict);
	List<Object[]> findEventByMemberId(Integer memberId);
	List<Object[]> popularEvents();
	List<Object[]> onGoingEvents();
	List<Object[]> parEventByMember(Integer memberId);
}
