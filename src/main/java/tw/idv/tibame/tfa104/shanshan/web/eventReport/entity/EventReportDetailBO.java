package tw.idv.tibame.tfa104.shanshan.web.eventReport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class EventReportDetailBO extends Core{
	@Id
	@Column(name = "eventReportID")
	private Integer eventReportID;
	
	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "eventId")
	private Integer eventId;
	
	@Column(name = "reportReason")
	private Integer reportReason;
	
	@Column(name = "reportDate")
	private Timestamp reportDate;
	
	@Column(name = "caseDone")
	private Timestamp caseDone;
	
	@Column(name = "caseStatus")
	private Integer caseStatus;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "memberUsername")
	private String memberUsername;
	
	@Column(name = "eventContent" , columnDefinition = "TEXT")
	private String eventContent;

	public Integer getEventReportID() {
		return eventReportID;
	}

	public void setEventReportID(Integer eventReportID) {
		this.eventReportID = eventReportID;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getReportReason() {
		return reportReason;
	}

	public void setReportReason(Integer reportReason) {
		this.reportReason = reportReason;
	}

	public Timestamp getReportDate() {
		return reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public Timestamp getCaseDone() {
		return caseDone;
	}

	public void setCaseDone(Timestamp caseDone) {
		this.caseDone = caseDone;
	}

	public Integer getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberUsername() {
		return memberUsername;
	}

	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	@Override
	public String toString() {
		return "EventReportDetailBO [eventReportID=" + eventReportID + ", memberId=" + memberId + ", eventId=" + eventId
				+ ", reportReason=" + reportReason + ", reportDate=" + reportDate + ", caseDone=" + caseDone
				+ ", caseStatus=" + caseStatus + ", memberName=" + memberName + ", memberUsername=" + memberUsername
				+ ", eventContent=" + eventContent + "]";
	}
	
	
}
