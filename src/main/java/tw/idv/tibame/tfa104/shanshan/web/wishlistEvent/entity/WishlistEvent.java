package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
@Table(name = "wishlist_event")
public class WishlistEvent extends Core {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_event_id")
	private Integer wishlistEventId;
	@Column(name = "member_id")
	private Integer memberId;
	@Column(name = "event_id")
	private Integer eventId;

//	private Event event;

//	@ManyToOne
////	@JoinColumn(foreignKey = @ForeignKey(name = "FK_wishlist_event_event_id"))
//	@JoinColumn(name ="event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
//	public Event getEvent() {
//		return event;
//	}
//
//	public void setEvent(Event event) {
//		this.event = event;
//	}

	public Integer getWishlistEventId() {
		return wishlistEventId;
	}

	public void setWishlistEventId(Integer wishlistEventId) {
		this.wishlistEventId = wishlistEventId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

}
