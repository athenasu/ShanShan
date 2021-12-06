package tw.idv.tibame.tfa104.shanshan.web.participant.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
@Table(name = "participant")
public class Participantsss extends Core{
	
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
	
	@Column(name = "join_date")
	private Timestamp joinDate;
	
	@Column(name = "total_participants")
	private Integer totalParticipants;
	
	public Participant(int partID, int eventID, int memberID, boolean experience, String phoneNumber,
			boolean participation, Timestamp joinDate, int totalParticipants) {
		super();
		this.partId = partID;
		this.eventId = eventID;
		this.memberId = memberID;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.participation = participation;
		this.joinDate = joinDate;
		this.totalParticipants = totalParticipants;
	}

	public int getPartID() {
		return partId;
	}

	public void setPartID(int partID) {
		this.partId = partID;
	}

	public int getEventID() {
		return eventId;
	}

	public void setEventID(int eventID) {
		this.eventId = eventID;
	}

	public int getMemberID() {
		return memberId;
	}

	public void setMemberID(int memberID) {
		this.memberId = memberID;
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

	public int getTotalParticipants() {
		return totalParticipants;
	}

	public void setTotalParticipants(int totalParticipants) {
		this.totalParticipants = totalParticipants;
	}

	@Override
	public String toString() {
		return "participant [partID=" + partId + ", eventID=" + eventId + ", memberID=" + memberId + ", experience="
				+ experience + ", phoneNumber=" + phoneNumber + ", participation=" + participation + ", joinDate="
				+ joinDate + ", totalParticipants=" + totalParticipants + "]";
	}
}

