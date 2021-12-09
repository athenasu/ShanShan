package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;

public interface WishlistEventDao {

	// create: add wishlistEvent (can use just memberId and eventId)
	public Integer addWishlistEvent(WishlistEvent wishlistEvent);
	// delete: delete wishlistEvent using wishlistEventId
	public Integer deleteWishlistEvent(WishlistEvent wishlistEvent);
	// delete: delete wishlistEvent using memberId and eventId
	public Integer deleteWishlistEventByMemIdEventId(Integer memberId, Integer eventId);
	// select: find all wishlistEventBOs using memberId
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId);
	// select: find all wishlistEvents by memberId
	public List<WishlistEvent> findAllWishlistEventByMemId(Integer memberId);
	
}
