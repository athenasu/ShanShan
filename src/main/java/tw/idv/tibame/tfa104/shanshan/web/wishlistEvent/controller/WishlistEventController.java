package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.service.WishlistEventService;


@RestController
@RequestMapping("wishlistEvent")
public class WishlistEventController {

	@Autowired
	private WishlistEventService wishlistService;

	@CrossOrigin
	@PostMapping("addWishlistEvent")
	public Boolean addWishlistEvent(@RequestBody WishlistEvent wishlistEvent) { 
		return wishlistService.addWishlistEvent(wishlistEvent);
	}
	@CrossOrigin
	@PostMapping("deleteWishlistEvent")
	public Boolean deleteWishlistEvent(@RequestBody WishlistEvent wishlistEvent) {
		return wishlistService.deleteWishlistEvent(wishlistEvent);
	}
	@CrossOrigin
	@PostMapping("deleteWishlistEventByMemIdEventId")
	public Boolean deleteWishlistEventByMemIdEventId(@RequestBody WishlistEvent wishlistEvent) {
		return wishlistService.deleteWishlistEventByMemIdEventId(wishlistEvent.getMemberId(), wishlistEvent.getEventId());
	}
	@CrossOrigin
	@GetMapping("findAllWishlistEventByMemId")
	public List<WishlistEvent> findAllWishlistEventByMemId(HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return wishlistService.findAllWishlistEventByMemId(memberId);
	}
	@CrossOrigin
	@GetMapping("findWishlistEventByMemberIdEventId")
	public WishlistEvent findWishlistEventByMemberIdEventId (HttpSession session, Integer eventId) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return wishlistService.findWishlistEventByMemberIdEventId(memberId, eventId);
	}
	
	@CrossOrigin
	@GetMapping("findWishlistEventsByMemberId")
	public List<WishlistEventBO> findWishlistEventsByMemberId(HttpSession session) { // need to change this back to Integer
		Integer memberId = (Integer) session.getAttribute("memberId");
		return wishlistService.findWishlistEventsByMemberId(memberId);
	}
}
