package tw.idv.tibame.tfa104.shanshan.web.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;



@RestController
@RequestMapping("event")
@SessionAttributes({ "event" })
public class EventController{
	@Autowired
	private EventService eventService;
	
	@GetMapping("updateEvent")
	public Event updateEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);		
	}
	
	@GetMapping("submitEvent")
	public int submitEvent(@RequestBody Event event){
		return eventService.submitEvent(event);
	}
	
	@GetMapping("List<Event>")
	public List<Event> eventList() {
		final List<Event> eventlist = eventService.selectAll();
		return eventlist;
	}
	
	@GetMapping("findEventByDistrict")
	public List<DistrictEventBO> eventlistbydisctrict(){
		final List<DistrictEventBO> eventlistbydisctrict = eventService.findEventByDistrict(2); //set the parameter as 2 for test
		return eventlistbydisctrict;
	}
	
	@GetMapping("findEventByMemberId")
	public List<MemberEventBO> findByMemberId(Integer memberId, Integer eventId) {
		final List<MemberEventBO> eventlistbymember = eventService.findEventByMemberId(1, 1); //set the parameter as 1 for test
		return eventlistbymember;
	}
	
	@CrossOrigin
	@GetMapping("popularEvents")
	public List<PopularEventBO> popularEvents(){
		final List<PopularEventBO> popularevents = eventService.popularEvents();
		return popularevents;
	}
	
	@GetMapping("onGoingEvents")
	public List<OnGoingEventBO> ongoingevents(){
		final List<OnGoingEventBO> ongoingevents = eventService.onGoingEvents();
		return ongoingevents;
	}
	
	@GetMapping("eventList")
	public List<Object[]> eventlist(){
		final List<Object[]> eventlist = eventService.eventList();
		return eventlist;
	}
	
	@GetMapping("parEventByMember")
	public List<ParEventBO> parEventByMember(){
		final List<ParEventBO> pareventbymember = eventService.parEventByMember(1);	//set the parameter as 1 for test
		return pareventbymember;
				
	}
}
