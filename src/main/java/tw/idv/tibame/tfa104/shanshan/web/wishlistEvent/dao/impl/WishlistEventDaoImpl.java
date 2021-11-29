package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.dao.WishlistEventDao;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEventBO;

@Repository
public class WishlistEventDaoImpl implements WishlistEventDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public Integer addWishlistEvent(WishlistEvent wishlistEvent) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(wishlistEvent); // returns an id
	}
	
	@Override
	public Integer deleteWishlistEvent(WishlistEvent wishlistEvent) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(wishlistEvent);
		return 1;
	}
	
	@Override
	public List<WishlistEventBO> findWishlistEventsByMemberId(Integer memberId){
		Session session = sessionFactory.getCurrentSession();
		List<WishlistEventBO> wishlistEvents = session.createNativeQuery(
			"select " +
				"we.wishlist_event_id as eventWishlistId, " +
		        "e.event_id as eventId, " +
		        "e.event_name as eventName, " +
		        "e.stay_type as stayType, " +
		        "e.event_start_date as eventStartDate, " +
		        "mtn.mountain_name as mountainName, " +
		        "mtn.mountain_pic as mountainPic, " +
		        "m.member_name as memberName, " +
		        "m.member_profile_pic as memberProfilePic" + 
		    " from " +
		        "wishlist_event we " + 
		    "join event e " + 
		        "on we.event_id = e.event_id " +
		    "join mountain mtn " + 
		        "on e.mountain_id = mtn.mountain_id " +
		    "join member m " + 
		    	"on e.member_id = m.member_id " + 
		    "where " +
		       "we.member_id = :id " +
		    "order by we.wishlist_event_id desc" ,WishlistEventBO.class)
			.setParameter("id", memberId)
			.list();
		return wishlistEvents;
	}
}
