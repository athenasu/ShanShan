package tw.idv.tibame.tfa104.shanshan.web.event.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventsMountainBO;


public interface EventDAO {

	int addEvent(Event event);
	Event updateEventById(Event event);
	Event selectByEventId(Integer eventId);	
	List<MemberEventBO> selectByMemberId(Integer memberId, Integer eventId);
	List<MemberEventBO> selectByMemberId(Integer memberId);
	List<Event> selectAll();
	int deleteEventById(Integer eventId); //udpate eventStatus to 0	
	List<DistrictEventBO> selectByDistrict(Integer mountainDistrict);	
	List<PopularEventBO> popularEvents();	
	List<OnGoingEventBO> onGoingEvents();
	List<Object[]> eventList();
	List<ParEventBO> parEventByMember(Integer memberId);
	List<PopularEventsMountainBO> popularMountains();

}