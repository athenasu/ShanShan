package tw.idv.tibame.tfa104.shanshan.web.participant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;


@Entity
@DynamicInsert
@Table(name = "participant")
public class Participant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "part_id")
	private Integer partId;
	
	@Column(name = "event_id")
	private Integer eventId;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "experience")
	private boolean experience;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "participation")
	private boolean participation;
	
	@Column(name = "join_date", updatable = false)
	private Timestamp joinDate;
	
	@Column(name = "total_participants")
	private Integer totalParticipants;

	public Integer getPartId() {
		return partId;
	}

	public void setPartId(Integer partId) {
		this.partId = partId;
	}

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

	public boolean isExperience() {
		return experience;
	}

	public void setExperience(boolean experience) {
		this.experience = experience;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isParticipation() {
		return participation;
	}

	public void setParticipation(boolean participation) {
		this.participation = participation;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(Integer totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Participant [partId=" + partId + ", eventId=" + eventId + ", memberId=" + memberId + ", experience="
				+ experience + ", phoneNumber=" + phoneNumber + ", participation=" + participation + ", joinDate="
				+ joinDate + ", totalParticipants=" + totalParticipants + "]";
	}
	

}

