package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class MemberEventBO extends Core{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventId")
	private Integer eventId;

	@Column(name = "eventName")
	private String eventName;

//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "eventStartDate")
	private Date eventStartDate;

//	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "eventDeadline")
	private Date eventDeadline;
	
	@Column(name = "eventStatus")
	private Integer eventStatus;
	
	@Column(name = "eventCurPart")
	private Integer eventCurPart;
	
	@Column(name = "maxNumOfPeople")
	private Integer maxNumOfPeople;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "mountainLongitude")
	private BigDecimal mountainLongitude;
	
	@Column(name = "mountainLatitude")
	private BigDecimal mountainLatitude;
	
	@Column(name = "mountainPic")
	private Byte[] mountainPic;
	
//	@Column(name = "participantMemberName")
//	private String participantMemberName;
//	
//	@Column(name = "participantMemberEmail")
//	private String participantMemberEmail;
	
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

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventDeadline() {
		return eventDeadline;
	}

	public void setEventDeadline(Date eventDeadline) {
		this.eventDeadline = eventDeadline;
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

	public Integer getMaxNumOfPeople() {
		return maxNumOfPeople;
	}

	public void setMaxNumOfPeople(Integer maxNumOfPeople) {
		this.maxNumOfPeople = maxNumOfPeople;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public BigDecimal getMountainLongitude() {
		return mountainLongitude;
	}

	public void setMountainLongitude(BigDecimal mountainLongitude) {
		this.mountainLongitude = mountainLongitude;
	}

	public BigDecimal getMountainLatitude() {
		return mountainLatitude;
	}

	public void setMountainLatitude(BigDecimal mountainLatitude) {
		this.mountainLatitude = mountainLatitude;
	}

	public Byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(Byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

//	public String getParticipantMemberName() {
//		return participantMemberName;
//	}
//
//	public void setParticipantMemberName(String participantMemberName) {
//		this.participantMemberName = participantMemberName;
//	}
//
//	public String getParticipantMemberEmail() {
//		return participantMemberEmail;
//	}
//
//	public void setParticipantMemberEmail(String participantMemberEmail) {
//		this.participantMemberEmail = participantMemberEmail;
//	}

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
		return "MemberEventBO [eventId=" + eventId + ", eventName=" + eventName + ", eventStartDate=" + eventStartDate
				+ ", eventDeadline=" + eventDeadline + ", eventStatus=" + eventStatus + ", eventCurPart=" + eventCurPart
				+ ", maxNumOfPeople=" + maxNumOfPeople + ", mountainName=" + mountainName + ", mountainLongitude="
				+ mountainLongitude + ", mountainLatitude=" + mountainLatitude + ", mountainPic="
				+ Arrays.toString(mountainPic) + ", memberId=" + memberId + "]";
	}

}
