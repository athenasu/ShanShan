package tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_msg")
public class eventMsg {
	private Integer eventMsgId;
	private Integer memberID;
	private Integer eventID;
	private Timestamp msgDate;
	private String msgContent;
	private Integer msgStatus;
	
	public eventMsg(int eventMsgId, int memberID, int eventID, Timestamp msgDate, String msgContent, int msgStatus) {
		super();
		this.eventMsgId = eventMsgId;
		this.memberID = memberID;
		this.eventID = eventID;
		this.msgDate = msgDate;
		this.msgContent = msgContent;
		this.msgStatus = msgStatus;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_msg_id")
	public int getEventMsgId() {
		return eventMsgId;
	}

	public void setEventMsgId(int eventMsgId) {
		this.eventMsgId = eventMsgId;
	}
	
	@Column(name = "member_id")
	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	@Column(name = "event_id")
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	@Column(name = "msg_date")
	public Timestamp getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}

	@Column(name = "msg_content")
	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Column(name = "msg_status")
	public int getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(int msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Override
	public String toString() {
		return "eventMsg [eventMsgId=" + eventMsgId + ", memberID=" + memberID + ", eventID=" + eventID + ", msgDate="
				+ msgDate + ", msgContent=" + msgContent + ", msgStatus=" + msgStatus + "]";
	}
	
	
}
