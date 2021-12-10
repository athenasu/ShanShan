package tw.idv.tibame.tfa104.shanshan.web.event.dao.impl;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.DetailEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventsMountainBO;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

@Repository
public class EventDAOImpl implements EventDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int addEvent(Event event) {
		Session session = sessionFactory.getCurrentSession();
		session.save(event);	
		return 1;
	}
	
	@Override
	public int deleteEventById(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(eventId);
		return 1;
	}
	
	@Override
	public Integer updateEventById(Event event) {
		Session session = sessionFactory.getCurrentSession();
		Event tempEvent = session.get(Event.class, event.getEventId());
		
//		Event tempEvent = new Event();
		
		final Integer eventId = event.getEventId();
		if(eventId != null) {
			tempEvent.setEventId(eventId);
		}
		
		final Integer mountainId = event.getMountainId();
		if (mountainId != null) {
			tempEvent.setMountainId(mountainId);
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
		
		final Integer eventCurPart = event.getEventCurPart();
		if (eventCurPart != null) {
			tempEvent.setEventCurPart(eventCurPart);
		}

		session.update(tempEvent);
		return 1;
	}
	
//	@Override
//	public Event selectByEventId(Integer eventId) {
//		Session session = sessionFactory.getCurrentSession();
//		return session.get(Event.class, eventId);
//	}
	
	@Override
	public List<Event> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Event", Event.class).list();
	}


	@Override
	public List<DistrictEventBO> selectByDistrict(Integer mountainDistrict) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
											"a.member_id as memberId, "+
											"a.event_name as eventName, "+
											"a.event_start_date as eventStartDate, "+
											"a.mountain_id as mountainId, "+
											"b.mountain_name as mountainName, "+
											"b.mountain_pic as mountainPic, "+
											"c.member_name as memberName, "+
											"b.mountain_district as mountainDistrict "+
										"FROM Event a "+
										"JOIN Mountain b "+
											"ON a.mountain_id = b.mountain_id "+
										"JOIN Member c "+
											"ON a.member_id = c.member_id "+
										"WHERE a.event_status = 2 AND b.mountain_district = :mountainDistrict", DistrictEventBO.class)
				.setParameter("mountainDistrict", mountainDistrict).list();
	}

	@Override
	public List<MemberEventBO> selectByMemberId(Integer memberId, Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
												"a.member_id as memberId, "+
												"a.event_id as eventId, "+
												"a.event_name as eventName, "+
												"a.event_start_date as eventStartDate, "+
												"a.event_deadline as eventDeadline, "+
												"a.event_status as eventStatus, "+
												"a.event_cur_part as eventCurPart, "+
												"a.max_num_of_people as maxNumOfPeople, "+
												"b.mountain_name as mountainName, "+
												"b.mountain_longitude as mountainLongitude, "+
												"b.mountain_latitude as mountainLatitude, "+
												"b.mountain_pic as mountainPic, "+
												"d.member_name as participantMemberName, "+
												"d.member_email as participantMemberEmail "+
										 "FROM Event a JOIN Mountain b "+
												"ON a.mountain_id = b.mountain_id "+
										 "JOIN Participant c "+
												"ON a.event_id = c.event_id "+
										 "JOIN member d "+
												"ON c.member_id = d.member_id "+
										 "WHERE (a.member_id = :memberId AND a.event_id = :eventId)", MemberEventBO.class)
				.setParameter("memberId", memberId)
				.setParameter("eventId", eventId).list();
	}
	
	@Override
	public List<MemberEventBO> selectByMemberId(Integer memberId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
												"a.member_id as memberId, "+
												"a.event_id as eventId, "+
												"a.event_name as eventName, "+
												"a.event_start_date as eventStartDate, "+
												"a.event_deadline as eventDeadline, "+
												"a.event_status as eventStatus, "+
												"a.event_cur_part as eventCurPart, "+
												"a.max_num_of_people as maxNumOfPeople, "+
												"b.mountain_name as mountainName, "+
												"b.mountain_longitude as mountainLongitude, "+
												"b.mountain_latitude as mountainLatitude, "+
												"b.mountain_pic as mountainPic "+
//												"d.member_name as participantMemberName, "+
//												"d.member_email as participantMemberEmail "+
										 "FROM Event a JOIN Mountain b "+
												"ON a.mountain_id = b.mountain_id "+
//										 "JOIN Participant c "+
//												"ON a.event_id = c.event_id "+
										 "JOIN member c "+
												"ON a.member_id = c.member_id "+
										 "WHERE (a.member_id = :memberId)", MemberEventBO.class)
				.setParameter("memberId", memberId).list();
	}
	
	@Override
	public List<DetailEventBO> selectByEventId(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * "+
										 "FROM Event a "+
										 "JOIN Member b "+
												"ON a.member_id = b.member_id "+
										 "JOIN Mountain c "+
												"ON a.mountain_id = c.mountain_id "+
										 "WHERE (a.event_id = :eventId)", DetailEventBO.class)
				.setParameter("eventId", eventId).list();
	}

	@Override
	public List<PopularEventBO> popularEvents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT " +
												"a.event_id as eventId, "+
												"a.member_id as memberId, "+
												"a.event_start_date as eventStartDate, "+
												"a.event_name as eventName, "+
												"a.event_cur_part as eventCurPart, "+
												"a.event_status as eventStatus, "+
												"b.mountain_name as mountainName, "+
												"b.mountain_district as mountainDistrict, " +
												"a.mountain_id as mountainId, "+
												"a.stay_type as stayType, "+
												"c.member_name as memberName, "+
												"b.mountain_pic as mountainPic, "+
												"c.member_profile_pic as memberProfilePic "+
										 "FROM Event a JOIN Mountain b "+
										 		"ON a.mountain_id = b.mountain_id "+
										 "JOIN Member c "+
										 		"ON a.member_id = c.member_id "+
										 "WHERE a.event_status = 2 "+
										 "ORDER BY a.event_cur_part desc limit 5",PopularEventBO.class).list();
				
	}

	@Override
	public List<OnGoingEventBO> onGoingEvents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT " +
												"a.event_id as eventId, "+
												"a.mountain_id as mountainId, "+
												"a.member_id as memberId, "+
												"a.event_name as eventName, "+
												"a.event_deadline as eventDeadline, "+
												"a.max_num_of_people as maxNumOfPeople, "+
												"a.event_status as eventStatus, "+
												"a.event_cur_part as eventCurPart, "+
												"b.mountain_pic as mountainPic, "+
												"c.member_name as memberName, "+
												"b.mountain_name as mountainName, "+
												"c.member_profile_pic as memberProfilePic "+
										 "FROM Event a "+
										 "JOIN Mountain b "+
										 		"ON a.mountain_id = b.mountain_id "+
										 "JOIN Member c "+
										 		"ON a.member_id = c.member_id "+
										 "WHERE (curdate() - a.event_deadline <= 5 and a.max_num_of_people - a.event_cur_part <= 5)", OnGoingEventBO.class).list();
		////"FROM Event where (curdate() - eventStartDate <= 5 and maxNumOfPeople - eventCurPart <= 5)"
	}

	@Override
	public List<DetailEventBO> eventList() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("Select * "+
										 "FROM Event a "+
										 "JOIN Mountain b "+
												"ON a.mountain_id = b.mountain_id "+
										 "JOIN Member c "+
												"ON a.member_id = c.member_id", DetailEventBO.class).list();
	}

	@Override
	public List<ParEventBO> parEventByMember(Integer memberId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
											"b.event_id as eventId, "+
											"b.event_name as eventName, "+
											"b.event_status as eventStatus, "+
											"b.event_start_date as eventStartDate, "+
											"b.assembling_place as assemblingPlace, "+
											"c.mountain_name as mountainName, "+
											"b.event_cur_part as eventCurPart, "+
											"c.mountain_pic as mountainPic, "+
											"b.event_content as eventContent, "+
											"b.mountain_id as mountainId, "+
											"c.mountain_longitude as mountainLongitude, "+
											"c.mountain_latitude as mountainLatitude "+
										 "FROM Participant a "+
										 "JOIN Event b "+
										 	"ON a.event_id = b.event_id "+ 
										 "JOIN Mountain c "+
										 	"ON b.mountain_id = c.mountain_id "+
										 "WHERE a.member_id = :memberId", ParEventBO.class)
				.setParameter("memberId", memberId).list();
	
	}
	
	@Override
	public List<Member> parEventByEventId(Integer eventId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT *"+
										 "FROM Member a "+
										 "JOIN Participant b "+
										 	"ON a.member_id = b.member_id "+ 
										 "WHERE b.event_id = :eventId", Member.class)
				.setParameter("eventId", eventId).list();
	
	}
	
	@Override
	public List<PopularEventsMountainBO> popularMountains() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT "+
											"a.mountain_id as mountainId, "+
											"count(*) as count, "+
											"b.mountain_district as mountainDistrict, "+
											"b.mountain_name as mountainName, "+
											"b.mountain_pic as mountainPic "+
										"FROM Event a "+
										"JOIN Mountain b "+
											"ON a.mountain_id = b.mountain_id "+
										"WHERE a.event_status != 4"+
										"GROUP BY a.mountain_id "+
										"ORDER BY count desc limit 3", PopularEventsMountainBO.class).list();
	}
}
