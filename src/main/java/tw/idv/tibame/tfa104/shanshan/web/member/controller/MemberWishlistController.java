package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.MemberWishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberWishlistService;


@RestController // using Spring RESTful to use this controller, which means it will get JSON information
@RequestMapping("memberWishlist")
public class MemberWishlistController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private MemberWishlistService wishlistService;

	// find all wishlists by member id
	// this isn't working
	@PostMapping("findAllWishlistsByMemberId")
	public List<Member> findAllWishlists (){
		return service.findAllWishlists(1);
	}
	
	@PostMapping("findArticleWishlistsByMemberId")
	public List<MemberWishlistArticle> findWishlistArticle (){
		return wishlistService.findWishlistArticleByMemberId(2);
	}
	
	// need to test this once we have event information
	// find event wishlists by member id
	@PostMapping("findWishlistEventByMemberId")
	public List<Event> findWishlistEvents (Integer memberid){
		return service.findWishlistEventsByMemberId(memberid);
	}
	
	// find product wishlists by member id
//	@PostMapping("findWishlistProductByMemberId")
//	public List<WishlistProduct> findWishlistProduct (Integer id){
//		return service.findWishlistEvent(id);
//	}
	
	// will need to set like a class for certain buttons that come with the wishlist icons (if they click on it then run the add wishlist, if they click on it again, then delete it)
	@PostMapping("deleteWishlistEvent")
	public int deleteWishlistEvent(Integer id) {
		service.deleteWishlistEvent(id);
		return 1;
	}
}
