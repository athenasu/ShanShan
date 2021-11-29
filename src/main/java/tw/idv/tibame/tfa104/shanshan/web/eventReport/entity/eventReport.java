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
public class eventReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_report_id")
	private Integer eventReportID;
	
	@Column(name = "member_id")
	private Integer memberID;
	
	@Column(name = "event_id")
	private Integer eventID;
	
	@Column(name = "report_reason")
	private Integer reportReason;
	
	@Column(name = "report_date")
	private Timestamp reportDate;
	
	@Column(name = "case_done")
	private Timestamp caseDone;
	
	@Column(name = "case_status")
	private Integer caseStatus;
	
	public eventReport(int eventReportID, int memberID, int eventID, int reportReason, Timestamp reportDate,
			Timestamp caseDone, int caseStatus) {
		super();
		this.eventReportID = eventReportID;
		this.memberID = memberID;
		this.eventID = eventID;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
		this.caseDone = caseDone;
		this.caseStatus = caseStatus;
	}

	public int getEventReportID() {
		return eventReportID;
	}

	public void setEventReportID(int eventReportID) {
		this.eventReportID = eventReportID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getReportReason() {
		return reportReason;
	}

	public void setReportReason(int reportReason) {
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

	public int getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(int caseStatus) {
		this.caseStatus = caseStatus;
	}

	@Override
	public String toString() {
		return "eventReport [eventReportID=" + eventReportID + ", memberID=" + memberID + ", eventID=" + eventID
				+ ", reportReason=" + reportReason + ", reportDate=" + reportDate + ", caseDone=" + caseDone
				+ ", caseStatus=" + caseStatus + "]";
	}
	
	
}
