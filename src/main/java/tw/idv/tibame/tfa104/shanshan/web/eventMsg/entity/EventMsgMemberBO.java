package tw.idv.tibame.tfa104.shanshan.web.eventMsg.entity;



import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class EventMsgMemberBO extends Core {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name = "msgDate")
	private Timestamp msgDate;
	
	@Column(name = "eventMsgId")
	private Integer eventMsgId;
	
	@Column(name = "msgContent")
	private String msgContent;
	
	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "eventId")
	private Integer eventId;
		
	@Column(name = "memberName")
	private String memberName;
			
	@Column(name = "memberProfilePic")
	private byte[] memberProfilePic;

	public Timestamp getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}

	public Integer getEventMsgId() {
		return eventMsgId;
	}

	public void setEventMsgId(Integer eventMsgId) {
		this.eventMsgId = eventMsgId;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EventMsgMemberBO [msgDate=" + msgDate + ", eventMsgId=" + eventMsgId + ", msgContent=" + msgContent
				+ ", memberId=" + memberId + ", eventId=" + eventId + ", memberName=" + memberName
				+ ", memberProfilePic=" + Arrays.toString(memberProfilePic) + "]";
	}
	

}
