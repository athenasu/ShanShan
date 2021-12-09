package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class DetailEventBO extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "event_id")
	private Integer eventId;

	@Column(name = "member_id")
	private Integer memberId;

	@Column(name = "mountain_id")
	private Integer mountainId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_days")
	private Integer eventDays;

	@Column(name = "difficulty")
	private Integer difficulty;

	@Column(name = "event_deadline")
	private Date eventDeadline;

	@Column(name = "event_start_date")
	private Date eventStartDate;

	@Column(name = "event_post_date")
	private Timestamp eventPostDate;

	@Column(name = "stay_type")
	private Integer stayType;

	@Column(name = "min_num_of_people")
	private Integer minNumOfPeople;

	@Column(name = "max_num_of_people")
	private Integer maxNumOfPeople;

	@Column(name = "assembling_place")
	private String assemblingPlace;

	@Column(name = "event_content")
	private String eventContent;

	@Column(name = "event_status")
	private Integer eventStatus;

	@Column(name = "event_points")
	private Integer eventPoints;

	@Column(name = "event_cur_part")
	private Integer eventCurPart;

	@Column(name = "mountain_district")
	private Integer moutainDistrict;
	
	@Column(name = "mountain_name")
	private String mountainName;
	
	@Column(name = "mountain_longitude")
	private BigDecimal mountainLongitude;
	
	@Column(name = "mountain_latitude")
	private BigDecimal mountainLatitude;
	
	@Column(name = "mountain_pic")
	private Byte[] mountainPic;
	
	@Column(name = "mountain_info")
	private String mountainInfo;

	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	@Column(name = "member_password")
	private String memberPassword;
	
	@Column(name = "member_username")
	private String memberUsername;
	
	@Column(name = "member_phone_num")
	private String memberPhoneNum;
	
	@Column(name = "member_register_date")
	private Date memberRegisterDate;
	
	@Column(name = "member_profile_pic")
	private byte[] memberProfilePic;
	
	@Column(name = "member_intro")
	private String memberIntro;
	
	@Column(name = "member_status")
	private Integer memberStatus;
	
	@Column(name = "member_sum_points")
	private Integer memberSumPoints;
	
	@Column(name = "member_subscription")
	private Integer memberSubscription;

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

	public Integer getEventDays() {
		return eventDays;
	}

	public void setEventDays(Integer eventDays) {
		this.eventDays = eventDays;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Date getEventDeadline() {
		return eventDeadline;
	}

	public void setEventDeadline(Date eventDeadline) {
		this.eventDeadline = eventDeadline;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Timestamp getEventPostDate() {
		return eventPostDate;
	}

	public void setEventPostDate(Timestamp eventPostDate) {
		this.eventPostDate = eventPostDate;
	}

	public Integer getStayType() {
		return stayType;
	}

	public void setStayType(Integer stayType) {
		this.stayType = stayType;
	}

	public Integer getMinNumOfPeople() {
		return minNumOfPeople;
	}

	public void setMinNumOfPeople(Integer minNumOfPeople) {
		this.minNumOfPeople = minNumOfPeople;
	}

	public Integer getMaxNumOfPeople() {
		return maxNumOfPeople;
	}

	public void setMaxNumOfPeople(Integer maxNumOfPeople) {
		this.maxNumOfPeople = maxNumOfPeople;
	}

	public String getAssemblingPlace() {
		return assemblingPlace;
	}

	public void setAssemblingPlace(String assemblingPlace) {
		this.assemblingPlace = assemblingPlace;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Integer getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Integer getEventPoints() {
		return eventPoints;
	}

	public void setEventPoints(Integer eventPoints) {
		this.eventPoints = eventPoints;
	}

	public Integer getEventCurPart() {
		return eventCurPart;
	}

	public void setEventCurPart(Integer eventCurPart) {
		this.eventCurPart = eventCurPart;
	}

	public Integer getMoutainDistrict() {
		return moutainDistrict;
	}

	public void setMoutainDistrict(Integer moutainDistrict) {
		this.moutainDistrict = moutainDistrict;
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

	public String getMountainInfo() {
		return mountainInfo;
	}

	public void setMountainInfo(String mountainInfo) {
		this.mountainInfo = mountainInfo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberUsername() {
		return memberUsername;
	}

	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}

	public String getMemberPhoneNum() {
		return memberPhoneNum;
	}

	public void setMemberPhoneNum(String memberPhoneNum) {
		this.memberPhoneNum = memberPhoneNum;
	}

	public Date getMemberRegisterDate() {
		return memberRegisterDate;
	}

	public void setMemberRegisterDate(Date memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}

	public byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public Integer getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Integer getMemberSumPoints() {
		return memberSumPoints;
	}

	public void setMemberSumPoints(Integer memberSumPoints) {
		this.memberSumPoints = memberSumPoints;
	}

	public Integer getMemberSubscription() {
		return memberSubscription;
	}

	public void setMemberSubscription(Integer memberSubscription) {
		this.memberSubscription = memberSubscription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DetailEvent [eventId=" + eventId + ", memberId=" + memberId + ", mountainId=" + mountainId
				+ ", eventName=" + eventName + ", eventDays=" + eventDays + ", difficulty=" + difficulty
				+ ", eventDeadline=" + eventDeadline + ", eventStartDate=" + eventStartDate + ", eventPostDate="
				+ eventPostDate + ", stayType=" + stayType + ", minNumOfPeople=" + minNumOfPeople + ", maxNumOfPeople="
				+ maxNumOfPeople + ", assemblingPlace=" + assemblingPlace + ", eventContent=" + eventContent
				+ ", eventStatus=" + eventStatus + ", eventPoints=" + eventPoints + ", eventCurPart=" + eventCurPart
				+ ", moutainDistrict=" + moutainDistrict + ", mountainName=" + mountainName + ", mountainLongitude="
				+ mountainLongitude + ", mountainLatitude=" + mountainLatitude + ", mountainPic="
				+ Arrays.toString(mountainPic) + ", mountainInfo=" + mountainInfo + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberPassword=" + memberPassword + ", memberUsername="
				+ memberUsername + ", memberPhoneNum=" + memberPhoneNum + ", memberRegisterDate=" + memberRegisterDate
				+ ", memberProfilePic=" + Arrays.toString(memberProfilePic) + ", memberIntro=" + memberIntro
				+ ", memberStatus=" + memberStatus + ", memberSumPoints=" + memberSumPoints + ", memberSubscription="
				+ memberSubscription + "]";
	}

}
