package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;

public interface WishlistEventDao {

	public Integer addWishlistEvent(WishlistEvent wishlistEvent);
	public Integer deleteWishlistEvent(WishlistEvent wishlistEvent);
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId);
	
}
