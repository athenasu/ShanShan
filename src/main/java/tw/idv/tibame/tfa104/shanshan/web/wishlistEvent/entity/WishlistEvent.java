package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.Core;
import tw.idv.tibame.tfa104.shanshan.web.Event.entity.Event;

@Entity
@Table(name = "wishlist_event")
public class WishlistEvent extends Core {

	private static final long serialVersionUID = 1L;

	private Integer wishlistEventId;
	private Integer memberId;
	private Integer eventId;
	private boolean favorite_status;
	private Event event;

	@ManyToOne
//	@JoinColumn(foreignKey = @ForeignKey(name = "FK_wishlist_event_event_id"))
	@JoinColumn(name ="event_id", referencedColumnName = "event_id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_event_id")
	public Integer getWishlistEventId() {
		return wishlistEventId;
	}

	public void setWishlistEventId(Integer wishlistEventId) {
		this.wishlistEventId = wishlistEventId;
	}

	@Column(name = "member_id")
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "event_id", insertable = false, updatable = false)
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Column(name = "favorite_status")
	public boolean getFavorite_status() {
		return favorite_status;
	}

	public void setFavorite_status(boolean favorite_status) {
		this.favorite_status = favorite_status;
	}

}
