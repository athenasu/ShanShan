package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class OnGoingEventBO extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventId")
	private Integer eventId;
	
	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "eventDeadline")
	private Date eventDeadline;
	
	@Column(name = "maxNumOfPeople")
	private Integer maxNumOfPeople;
	
	@Column(name = "eventStatus")
	private Integer eventStatus;
	
	@Column(name = "eventCurPart")
	private Integer eventCurPart;
	
	@Column(name = "mountainPic")
	private Byte[] mountainPic;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "memberProfilePic")
	private Byte[] memberProfilePic;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "mountainId")
	private Integer mountainId;
	
	@Column(name = "memberId")
	private Integer memberId;

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

	public Date getEventDeadline() {
		return eventDeadline;
	}

	public void setEventDeadline(Date eventDeadline) {
		this.eventDeadline = eventDeadline;
	}

	public Integer getMaxNumOfPeople() {
		return maxNumOfPeople;
	}

	public void setMaxNumOfPeople(Integer maxNumOfPeople) {
		this.maxNumOfPeople = maxNumOfPeople;
	}

	public Integer getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Integer getEventCurPart() {
		return eventCurPart;
	}

	public void setEventCurPart(Integer eventCurPart) {
		this.eventCurPart = eventCurPart;
	}

	public Byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(Byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(Byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OnGoingEvents [eventId=" + eventId + ", eventName=" + eventName + ", eventDeadline=" + eventDeadline
				+ ", maxNumOfPeople=" + maxNumOfPeople + ", eventStatus=" + eventStatus + ", eventCurPart="
				+ eventCurPart + ", mountainPic=" + Arrays.toString(mountainPic) + ", memberName=" + memberName
				+ ", memberProfilePic=" + Arrays.toString(memberProfilePic) + ", mountainName=" + mountainName
				+ ", mountainId=" + mountainId + ", memberId=" + memberId + "]";
	}
}
