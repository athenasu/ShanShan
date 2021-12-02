package tw.idv.tibame.tfa104.shanshan.web.event.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventsMountainBO;
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
	public List<Event> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public List<DistrictEventBO> findEventByDistrict(Integer mountainDistrict){
		List<DistrictEventBO> districtEvents = dao.selectByDistrict(mountainDistrict);
		for(DistrictEventBO districtEvent : districtEvents) {
			districtEvent.setMountainPicStr(Base64.getEncoder().encodeToString(districtEvent.getMountainPic()));
		}		
		return districtEvents;
	}
	
	@Override
	public List<MemberEventBO> findEventByMemberId(Integer memberId, Integer eventId) {
		return  dao.selectByMemberId(memberId, eventId);
	}

	@Override
	public List<PopularEventBO> popularEvents() {
		return dao.popularEvents();
	}

	@Override
	public List<OnGoingEventBO> onGoingEvents() {
		return dao.onGoingEvents();
	}

	@Override
	public List<Object[]> eventList() {
		return dao.eventList();
	}

	@Override
	public List<ParEventBO> parEventByMember(Integer memberId) {
		return dao.parEventByMember(memberId);
	}

	@Override
	public List<PopularEventsMountainBO> findPopularMountains() {
		return dao.popularMountains();
	}

}
