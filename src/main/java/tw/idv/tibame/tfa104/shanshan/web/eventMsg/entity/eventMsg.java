package tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity;

import java.sql.Timestamp;

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

	public int getEventMsgId() {
		return eventMsgId;
	}

	public void setEventMsgId(int eventMsgId) {
		this.eventMsgId = eventMsgId;
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
