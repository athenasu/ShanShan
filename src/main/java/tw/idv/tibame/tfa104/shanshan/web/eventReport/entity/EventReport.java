package tw.idv.tibame.tfa104.shanshan.web.eventReport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_report")
public class EventReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_report_id")
	private Integer eventReportID;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "event_id")
	private Integer eventId;
	
	@Column(name = "report_reason")
	private Integer reportReason;
	
	@Column(name = "report_date")
	private Timestamp reportDate;
	
	@Column(name = "case_done")
	private Timestamp caseDone;
	
	@Column(name = "case_status")
	private Integer caseStatus;

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

	@Override
	public String toString() {
		return "EventReport [eventReportID=" + eventReportID + ", memberId=" + memberId + ", eventId=" + eventId
				+ ", reportReason=" + reportReason + ", reportDate=" + reportDate + ", caseDone=" + caseDone
				+ ", caseStatus=" + caseStatus + "]";
	}
	

}
