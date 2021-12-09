package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.controller;

import java.util.List;

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
	
	@PostMapping("deleteWishlistEvent")
	public Boolean deleteWishlistEvent(@RequestBody WishlistEvent wishlistEvent) {
		return wishlistService.deleteWishlistEvent(wishlistEvent);
	}
	
	@PostMapping("deleteWishlistEventByMemIdEventId")
	public Boolean deleteWishlistEventByMemIdEventId(@RequestBody WishlistEvent wishlistEvent) {
		return wishlistService.deleteWishlistEventByMemIdEventId(wishlistEvent.getMemberId(), wishlistEvent.getEventId());
	}
	
	@GetMapping("findAllWishlistEventByMemId")
	public List<WishlistEvent> findAllWishlistEventByMemId(Integer memberId) {
		return wishlistService.findAllWishlistEventByMemId(memberId);
	}
	
	@GetMapping("findWishlistEventsByMemberId")
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId) { // need to change this back to Integer
		return wishlistService.findWishlistEventsByMemberId(1);
	}
}
