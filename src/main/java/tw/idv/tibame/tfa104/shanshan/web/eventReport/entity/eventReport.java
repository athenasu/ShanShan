package tw.idv.tibame.tfa104.shanshan.web.eventReport.entity;

import java.sql.Timestamp;

public class eventReport {
	private Integer eventReportID;
	private Integer memberID;
	private Integer eventID;
	private Integer reportReason;
	private Timestamp reportDate;
	private Timestamp caseDone;
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
