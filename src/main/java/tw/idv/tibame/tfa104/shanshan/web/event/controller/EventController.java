package tw.idv.tibame.tfa104.shanshan.web.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;



@RestController
@RequestMapping("event")
@SessionAttributes({ "event" })
public class EventController{
	@Autowired
	private EventService eventService;
	
	@GetMapping("findEventByEventId")
	public Event findEventByEventId() {
		final Event event = eventService.findEventByEventId(1); //set the parameter as 1 for test
		return event;
	}
	
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
	public List<Object[]> eventlistbydisctrict(){
		final List<Object[]> eventlistbydisctrict = eventService.findEventByDistrict(2); //set the parameter as 2 for test
		return eventlistbydisctrict;
	}
	
	@GetMapping("findEventByMemberId")
	public List<Object[]> findByMemberId() {
		final List<Object[]> eventlistbymember = eventService.findEventByMemberId(1); //set the parameter as 1 for test
		return eventlistbymember;
	}
	
	@GetMapping("popularEvents")
	public List<Object[]> popularEvents(){
		final List<Object[]> popularevents = eventService.popularEvents();
		return popularevents;
	}
	
	@GetMapping("onGoingEvents")
	public List<Object[]> ongoingevents(){
		final List<Object[]> ongoingevents = eventService.onGoingEvents();
		return ongoingevents;
	}
	
	@GetMapping("eventList")
	public List<Object[]> eventlist(){
		final List<Object[]> eventlist = eventService.eventList();
		return eventlist;
	}
	
	@GetMapping("parEventByMember")
	public List<Object[]> parEventByMember(){
		final List<Object[]> pareventbymember = eventService.parEventByMember(1);	//set the parameter as 1 for test
		return pareventbymember;
				
	}
}
