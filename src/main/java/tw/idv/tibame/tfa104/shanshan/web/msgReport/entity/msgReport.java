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
public class msgReport{
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

	public Integer getMsgReportID() {
		return msgReportID;
	}

	public void setMsgReportID(Integer msgReportID) {
		this.msgReportID = msgReportID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getEventMsgID() {
		return eventMsgID;
	}

	public void setEventMsgID(Integer eventMsgID) {
		this.eventMsgID = eventMsgID;
	}

	public Integer getActMsgID() {
		return actMsgID;
	}

	public void setActMsgID(Integer actMsgID) {
		this.actMsgID = actMsgID;
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
		return "msgReport [msgReportID=" + msgReportID + ", memberID=" + memberID + ", eventMsgID=" + eventMsgID
				+ ", actMsgID=" + actMsgID + ", reportReason=" + reportReason + ", reportDate=" + reportDate
				+ ", caseDone=" + caseDone + ", caseStatus=" + caseStatus + "]";
	}
	
	
}
