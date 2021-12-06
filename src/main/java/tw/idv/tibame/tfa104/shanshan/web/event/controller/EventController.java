package tw.idv.tibame.tfa104.shanshan.web.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.DetailEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.DistrictEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.OnGoingEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.PopularEventsMountainBO;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;



@RestController
@RequestMapping("event")
@SessionAttributes({ "event" })
public class EventController{
	@Autowired
	private EventService eventService;
	
	@CrossOrigin
	@PostMapping("updateEvent")
	public Event updateEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);		
	}
	
	@CrossOrigin
	@PostMapping(path = "addEvent", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addEvent(@RequestBody Event event){
		return eventService.addEvent(event);
	}
	
	@CrossOrigin
	@GetMapping("List<Event>")
	public List<Event> eventList() {
		final List<Event> eventlist = eventService.selectAll();
		return eventlist;
	}
	
	@CrossOrigin
	@GetMapping("findEventByDistrict")
	public List<DistrictEventBO> eventlistbydisctrict(){
		final List<DistrictEventBO> eventlistbydisctrict = eventService.findEventByDistrict(2); //set the parameter as 2 for test
		return eventlistbydisctrict;
	}

//	@CrossOrigin
//	@GetMapping("findEventByMemberId")
//	public List<MemberEventBO> findByMemberId(Integer memberId, Integer eventId) {
//		final List<MemberEventBO> eventlistbymember = eventService.findEventByMemberId(1, 1); //set the parameter as 1 for test
//		return eventlistbymember;
//	}
	
	@CrossOrigin
	@GetMapping("findEventByMemberId1")
	public List<MemberEventBO> findByMemberId(Integer memberId) {
		final List<MemberEventBO> eventlistbymember = eventService.findEventByMemberId(1); //set the parameter as 1 for test
		return eventlistbymember;
	}
	
	@CrossOrigin
	@GetMapping("findEventByEventId")
	public List<DetailEventBO> findEventByEventId(Integer eventId) {
		final List<DetailEventBO> eventdetail = eventService.findEventByEventId(eventId); //set the parameter as 1 for test
		return eventdetail;
	}
	
	@CrossOrigin
	@GetMapping("popularEvents")
	public List<PopularEventBO> popularEvents(){
		final List<PopularEventBO> popularevents = eventService.popularEvents();
		return popularevents;
	}
	
	@CrossOrigin
	@GetMapping("onGoingEvents")
	public List<OnGoingEventBO> ongoingevents(){
		final List<OnGoingEventBO> ongoingevents = eventService.onGoingEvents();
		return ongoingevents;
	}
	
	@CrossOrigin
	@GetMapping("eventList")
	public List<DetailEventBO> eventlist(){
		final List<DetailEventBO> eventlist = eventService.eventList();
		return eventlist;
	}
	
	@CrossOrigin
	@GetMapping("parEventByMember")
	public List<ParEventBO> parEventByMember(){
		final List<ParEventBO> pareventbymember = eventService.parEventByMember(1);	//set the parameter as 1 for test
		return pareventbymember;				
	}
	
	@CrossOrigin
	@GetMapping("findPopularMountain")
	public List<PopularEventsMountainBO> popularMountains(){
		final List<PopularEventsMountainBO> popularmountains = eventService.findPopularMountains();	//set the parameter as 1 for test
		return popularmountains;				
	}
	
	@CrossOrigin
	@GetMapping("parEventByEventId")
	public List<Member> parEventByEventId(Integer eventId){
		final List<Member> pareventbyeventid = eventService.parEventByEventId(1);	//set the parameter as 1 for test
		return pareventbyeventid;				
	}
	
	@CrossOrigin
	@PostMapping(path = "addWishlistEvent", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer addWishlistEvent(@RequestBody WishlistEvent wishlistEvent){
		return eventService.addWishlistEvent(wishlistEvent);
	}
}
