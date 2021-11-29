package tw.idv.tibame.tfa104.shanshan.web.msgReport.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msg_report")
public class msgReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msg_report_id")
	private Integer msgReportID;
	
	@Column(name = "member_id")
	private Integer memberID;
	
	@Column(name = "event_msg_id")
	private Integer eventMsgID;
	
	@Column(name = "act_msg_id")
	private Integer actMsgID;
	
	@Column(name = "report_reason")
	private Integer reportReason;
	
	@Column(name = "report_date")
	private Timestamp reportDate;
	
	@Column(name = "case_done")
	private Timestamp caseDone;
	
	@Column(name = "case_status")
	private Integer caseStatus;
	
	public msgReport(int msgReportID, int memberID, int eventMsgID, int actMsgID, int reportReason,
			Timestamp reportDate, Timestamp caseDone, int caseStatus) {
		super();
		this.msgReportID = msgReportID;
		this.memberID = memberID;
		this.eventMsgID = eventMsgID;
		this.actMsgID = actMsgID;
		this.reportReason = reportReason;
		this.reportDate = reportDate;
		this.caseDone = caseDone;
		this.caseStatus = caseStatus;
	}

	public int getMsgReportID() {
		return msgReportID;
	}

	public void setMsgReportID(int msgReportID) {
		this.msgReportID = msgReportID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getEventMsgID() {
		return eventMsgID;
	}

	public void setEventMsgID(int eventMsgID) {
		this.eventMsgID = eventMsgID;
	}

	public int getActMsgID() {
		return actMsgID;
	}

	public void setActMsgID(int actMsgID) {
		this.actMsgID = actMsgID;
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
		return "msgReport [msgReportID=" + msgReportID + ", memberID=" + memberID + ", eventMsgID=" + eventMsgID
				+ ", actMsgID=" + actMsgID + ", reportReason=" + reportReason + ", reportDate=" + reportDate
				+ ", caseDone=" + caseDone + ", caseStatus=" + caseStatus + "]";
	}	
}
