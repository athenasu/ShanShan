package tw.idv.tibame.tfa104.shanshan.web.participant.entity;

import java.sql.Timestamp;

public class participant {
	private Integer partID;
	private Integer eventID;
	private Integer memberID;
	private boolean experience;
	private String phoneNumber;
	private boolean participation;
	private Timestamp joinDate;
	private Integer totalParticipants;
	
	public participant(int partID, int eventID, int memberID, boolean experience, String phoneNumber,
			boolean participation, Timestamp joinDate, int totalParticipants) {
		super();
		this.partID = partID;
		this.eventID = eventID;
		this.memberID = memberID;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.participation = participation;
		this.joinDate = joinDate;
		this.totalParticipants = totalParticipants;
	}

	public int getPartID() {
		return partID;
	}

	public void setPartID(int partID) {
		this.partID = partID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
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
		return "participant [partID=" + partID + ", eventID=" + eventID + ", memberID=" + memberID + ", experience="
				+ experience + ", phoneNumber=" + phoneNumber + ", participation=" + participation + ", joinDate="
				+ joinDate + ", totalParticipants=" + totalParticipants + "]";
	}
}

