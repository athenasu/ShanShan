package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;

public interface WishlistEventService {
	
	public Boolean addWishlistEvent(WishlistEvent wishlistEvent);
	public Boolean deleteWishlistEvent(WishlistEvent wishlistEvent);
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId);

}
