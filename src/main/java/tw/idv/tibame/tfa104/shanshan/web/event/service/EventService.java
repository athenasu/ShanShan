package tw.idv.tibame.tfa104.shanshan.web.event.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventsMountainBO;


public interface EventService {
	int submitEvent(Event event);
	Event updateEvent(Event event);
	Event deleteEvent(Event event); //change eventStatus
	List<Event> selectAll();
	List<Object[]> eventList();
	List<PopularEventBO> popularEvents();
	List<OnGoingEventBO> onGoingEvents();
	List<ParEventBO> parEventByMember(Integer memberId);
	List<MemberEventBO> findEventByMemberId(Integer memberId, Integer eventId);
	List<DistrictEventBO> findEventByDistrict(Integer districtId);
	List<PopularEventsMountainBO> findPopularMountains();

}
