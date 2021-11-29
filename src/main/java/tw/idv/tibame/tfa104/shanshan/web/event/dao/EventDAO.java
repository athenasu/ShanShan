package tw.idv.tibame.tfa104.shanshan.web.event.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;


public interface EventDAO {

	int addEvent(Event event);
	Event updateEventById(Event event);
	Event selectByEventId(Integer eventId);	
	List<Object[]> selectByMemberId(Integer memberId);
	List<Event> selectAll();
	int deleteEventById(Integer eventId); //udpate eventStatus to 0	
	List<Object[]> selectByDistrict(Integer mountainDistrict);	
	List<Object[]> popularEvents();	
	List<Object[]> onGoingEvents();
	List<Object[]> eventList();
	List<Object[]> parEventByMember(Integer memberId);
}