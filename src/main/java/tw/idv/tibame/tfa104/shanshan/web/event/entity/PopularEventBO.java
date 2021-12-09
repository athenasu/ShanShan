package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class PopularEventBO extends Core {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventId")
	private Integer eventId;

	@Column(name = "memberId")
	private Integer memberId;

	@Column(name = "mountainId")
	private Integer mountainId;

	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "mountainPic")
	private Byte[] mountainPic;
	
	@Column(name = "eventStartDate")
	private Date eventStartDate;
	
	@Column(name = "eventCurPart")
	private Integer eventCurPart;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "mountainDistrict")
	private Integer mountainDistrict;
	
	@Column(name = "stayType")
	private Integer stayType;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "eventStatus")
	private Integer eventStatus;
	
	@Column(name = "memberProfilePic")
	private Byte[] memberProfilePic;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(Byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Integer getEventCurPart() {
		return eventCurPart;
	}

	public void setEventCurPart(Integer eventCurPart) {
		this.eventCurPart = eventCurPart;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public Integer getMountainDistrict() {
		return mountainDistrict;
	}

	public void setMountainDistrict(Integer mountainDistrict) {
		this.mountainDistrict = mountainDistrict;
	}

	public Integer getStayType() {
		return stayType;
	}

	public void setStayType(Integer stayType) {
		this.stayType = stayType;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(Byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	@Override
	public String toString() {
		return "PopularEventBO [eventId=" + eventId + ", memberId=" + memberId + ", mountainId=" + mountainId
				+ ", eventName=" + eventName + ", mountainPic=" + Arrays.toString(mountainPic) + ", eventStartDate="
				+ eventStartDate + ", eventCurPart=" + eventCurPart + ", mountainName=" + mountainName
				+ ", mountainDistrict=" + mountainDistrict + ", stayType=" + stayType + ", memberName=" + memberName
				+ ", eventStatus=" + eventStatus + ", memberProfilePic=" + Arrays.toString(memberProfilePic) + "]";
	}


}
