package tw.idv.tibame.tfa104.shanshan.web.event.dao.impl;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addEvent(Event event) {
		Session session = sessionFactory.getCurrentSession();

		return (Integer) session.save(event);		
	}
	
	@Override
	public int deleteEventById(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(eventId);
		return 1;
	}
	
	@Override
	public Event updateEventById(Event event) {
		Session session = sessionFactory.getCurrentSession();
		Event tempEvent = session.get(Event.class, event.getEventID());
		
		final Integer mountainID = event.getMountainID();
		if (mountainID != null) {
			tempEvent.setMountainID(mountainID);
		}
		
		final String eventName = event.getEventName();
		if (eventName != null) {
			tempEvent.setEventName(eventName);
		}
		
		final Integer eventDays = event.getEventDays();
		if (eventDays != null) {
			tempEvent.setEventDays(eventDays);
		}
		
		final Integer difficulty = event.getDifficulty();
		if (difficulty != null) {
			tempEvent.setDifficulty(difficulty);
		}
		
		final Date eventDeadline = event.getEventDeadline();
		if (eventDeadline != null) {
			tempEvent.setEventDeadline(eventDeadline);
		}
		
		final Date eventStartDate = event.getEventStartDate();
		if (eventStartDate != null) {
			tempEvent.setEventStartDate(eventStartDate);
		}
		
		final Integer minNumOfPeople = event.getMinNumOfPeople();
		if (minNumOfPeople != null) {
			tempEvent.setMinNumOfPeople(minNumOfPeople);
		}
		
		final Integer maxNumOfPeople = event.getMaxNumOfPeople();
		if (maxNumOfPeople != null) {
			tempEvent.setMaxNumOfPeople(maxNumOfPeople);
		}
		
		final String assemblingPlace = event.getAssemblingPlace();
		if (assemblingPlace != null) {
			tempEvent.setAssemblingPlace(assemblingPlace);
		}
		
		final String eventContent = event.getEventContent();
		if (eventContent != null) {
			tempEvent.setEventContent(eventContent);
		}
		
		final Integer eventStatus = event.getEventStatus();
		if (eventStatus != null) {
			tempEvent.setEventStatus(eventStatus);
		}
		
		return tempEvent;
	}
	
	@Override
	public Event selectByEventId(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Event.class, eventId);
	}
	
	@Override
	public List<Event> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event", Event.class).list();
	}


	@Override
	public List<Object[]> selectByDistrict(Integer mountainDistrict) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event a join Mountain b WITH a.mountainId = b.mountainId WHERE b.moutainDistrict = :mountainDistrict", Object[].class)
				.setParameter("mountainDistrict", mountainDistrict).list();
	}

	@Override
	public List<Object[]> selectByMemberId(Integer memberId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event a join Mountain b WITH a.mountainId = b.mountainId WHERE a.memberId = :memberId", Object[].class)
				.setParameter("memberId", memberId).list();
	}

	@Override
	public List<Object[]> popularEvents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event a join Mountain b WITH a.mountainId = b.mountainId ORDER BY a.eventCurPart desc", Object[].class)
				.setMaxResults(5).list();
	}

	@Override
	public List<Object[]> onGoingEvents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event where (curdate() - eventStartDate <= 5 and maxNumOfPeople - eventCurPart <= 5)", Object[].class).list();
	}

	@Override
	public List<Object[]> eventList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event a join Mountain b WITH a.mountainId = b.mountainId", Object[].class).list();
	}

	@Override
	public List<Object[]> parEventByMember(Integer memberId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Participant a join Event b WITH a.eventId = b.eventId join mountain c WITH b.mountainId = c.mountainId WHERE a.memberId = :memberId", Object[].class)
				.setParameter("memberId", memberId).list();
	
	}


}
