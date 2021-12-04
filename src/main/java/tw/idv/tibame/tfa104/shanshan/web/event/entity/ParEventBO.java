package tw.idv.tibame.tfa104.shanshan.web.event.entity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ParEventBO {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventId")
	private Integer eventId;
	
	@Column(name = "eventName")
	private String eventName;
	
	@Column(name = "eventStatus")
	private Integer eventStatus;
	
	@Column(name = "eventStartDate")
	private Date eventStartDate;
	
	@Column(name = "assemblingPlace")
	private String assemblingPlace;
	
	@Column(name = "mountainName")
	private String mountainName;
	
	@Column(name = "eventCurPart")
	private Integer eventCurPart;
	
	@Column(name = "mountainPic")
	private byte[] mountainPic;
	
	@Column(name = "eventContent")
	private String eventContent;
	
	@Column(name = "mountainLongitude")
	private BigDecimal mountainLongitude;
	
	@Column(name = "mountainLatitude")
	private BigDecimal mountainLatitude;
	
	@Column(name = "mountainId")
	private Integer mountainId;
	
	@Transient
	private String picString;
	
	public String getPicString() {
		return picString;
	}

	public void setPicString(String picString) {
		this.picString = picString;
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

	public Integer getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getAssemblingPlace() {
		return assemblingPlace;
	}

	public void setAssemblingPlace(String assemblingPlace) {
		this.assemblingPlace = assemblingPlace;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public Integer getEventCurPart() {
		return eventCurPart;
	}

	public void setEventCurPart(Integer eventCurPart) {
		this.eventCurPart = eventCurPart;
	}

	public byte[] getMountainPic() {
		return mountainPic;
	}

	public void setMountainPic(byte[] mountainPic) {
		this.mountainPic = mountainPic;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
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

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ParEventBO [eventId=" + eventId + ", eventName=" + eventName + ", eventStatus=" + eventStatus
				+ ", eventStartDate=" + eventStartDate + ", assemblingPlace=" + assemblingPlace + ", mountainName="
				+ mountainName + ", eventCurPart=" + eventCurPart + ", mountainPic=" + Arrays.toString(mountainPic)
				+ ", eventContent=" + eventContent + ", mountainLongitude=" + mountainLongitude + ", mountainLatitude="
				+ mountainLatitude + ", mountainId=" + mountainId + "]";
	}
	

}
