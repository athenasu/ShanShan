package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class DistrictEventBO extends Core{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "eventStartDate")
	private Date eventStartDate;
	
	@Column(name = "mountainId")
	private Integer mountainId;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "mountainPic")
	private byte[] mountainPic;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "mountainDistrict")
	private Integer mountainDistrict;
	
	@Transient
	private String mountainPicStr;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
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

	public Integer getMountainDistrict() {
		return mountainDistrict;
	}

	public void setMountainDistrict(Integer mountainDistrict) {
		this.mountainDistrict = mountainDistrict;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMountainPicStr() {
		return mountainPicStr;
	}

	public void setMountainPicStr(String memberProfilePicStr) {
		this.mountainPicStr = memberProfilePicStr;
	}

	@Override
	public String toString() {
		return "DistrictEventBO [memberId=" + memberId + ", eventName=" + eventName + ", eventStartDate="
				+ eventStartDate + ", mountainId=" + mountainId + ", mountainName=" + mountainName + ", mountainPic="
				+ Arrays.toString(mountainPic) + ", memberName=" + memberName + ", mountainDistrict=" + mountainDistrict
				+ ", mountainPicStr=" + mountainPicStr + "]";
	}
}
