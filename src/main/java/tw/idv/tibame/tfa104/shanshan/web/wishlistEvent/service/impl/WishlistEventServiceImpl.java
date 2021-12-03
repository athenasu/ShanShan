package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.dao.WishlistEventDao;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.service.WishlistEventService;

@Service
@Transactional
public class WishlistEventServiceImpl implements WishlistEventService {
	
	@Autowired
	private WishlistEventDao dao;
	
	@Override
	public Boolean deleteWishlistEvent(WishlistEvent wishlistEvent) {
		int result = dao.deleteWishlistEvent(wishlistEvent);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean addWishlistEvent(WishlistEvent wishlistEvent) {
		int result = dao.addWishlistEvent(wishlistEvent);
		if (result > 0) {
			wishlistEvent.setSuccessful(true);
			return true;
		} else {
			wishlistEvent.setSuccessful(false);
			return false;
		}
	}
	
	@Override
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId) {
		List<WishlistEventBO> wishlistEvents = dao.findWishlistEventsByMemberId(memberId);
		for (WishlistEventBO wishlistEvent : wishlistEvents) {
			wishlistEvent.setMountainPicStr(Base64.getEncoder().encodeToString(wishlistEvent.getMountainPic()));
			wishlistEvent.setMemberProfilePicStr(Base64.getEncoder().encodeToString(wishlistEvent.getMemberProfilePic()));
		}
		return wishlistEvents;
	}
}
