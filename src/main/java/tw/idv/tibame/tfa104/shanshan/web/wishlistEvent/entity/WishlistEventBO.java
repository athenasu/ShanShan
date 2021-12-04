package tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class WishlistEventBO extends Core {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventWishlistId")
	private Integer eventWishlistId;
	@Column(name = "eventId")
	private Integer eventId;
	@Column(name = "eventName")
	private String eventName;
	@Column(name = "stayType")
	private Integer stayType;
	@Column(name = "eventStartDate")
	private Date eventStartDate;
	@Column(name = "mountainName")
	private String mountainName;
//	@Transient
	@Column(name = "mountainPic")
	private byte[] mountainPic;
	@Column(name = "memberName")
	private String memberName;
//	@Transient
	@Column(name = "memberProfilePic")
	private byte[] memberProfilePic;
	@Transient
	private String mountainPicStr;
	@Transient
	private String memberProfilePicStr;

	public Integer getEventWishlistId() {
		return eventWishlistId;
	}

	public void setEventWishlistId(Integer eventWishlistId) {
		this.eventWishlistId = eventWishlistId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getStayType() {
		return stayType;
	}

	public void setStayType(Integer stayType) {
		this.stayType = stayType;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	public String getMountainPicStr() {
		return mountainPicStr;
	}

	public void setMountainPicStr(String mountainPicStr) {
		this.mountainPicStr = mountainPicStr;
	}

	public String getMemberProfilePicStr() {
		return memberProfilePicStr;
	}

	public void setMemberProfilePicStr(String memberProfilePicStr) {
		this.memberProfilePicStr = memberProfilePicStr;
	}

}
