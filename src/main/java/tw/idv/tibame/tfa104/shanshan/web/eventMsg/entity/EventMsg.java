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
public class EventMsg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_msg_id")
	private Integer eventMsgId;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "event_id")
	private Integer eventId;
	
	@Column(name = "msg_date")
	private Timestamp msgDate;
	
	@Column(name = "msg_content")
	private String msgContent;
	
	@Column(name = "msg_status")
	private Integer msgStatus;

	public Integer getEventMsgId() {
		return eventMsgId;
	}

	public void setEventMsgId(Integer eventMsgId) {
		this.eventMsgId = eventMsgId;
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

	public Timestamp getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Integer getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(Integer msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Override
	public String toString() {
		return "EventMsg [eventMsgId=" + eventMsgId + ", memberId=" + memberId + ", eventId=" + eventId + ", msgDate="
				+ msgDate + ", msgContent=" + msgContent + ", msgStatus=" + msgStatus + "]";
	}


}
