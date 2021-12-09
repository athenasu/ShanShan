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
	@Column(name = "memberId")
	private String memberId;
	
	@Column(name = "eventId")
	private String eventId;
	
	@Column(name = "memberName")
	private String memberName;
	
	@Column(name = "memberProfilePic")
	private byte[] memberProfilePic;
	
	@Column(name = "msgContent")
	private String msgContent;
	
	@Column(name = "msgDate")
	private Timestamp msgDate;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
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

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Timestamp getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Timestamp msgDate) {
		this.msgDate = msgDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EventMsgMemberBO [memberId=" + memberId + ", eventId=" + eventId + ", memberName=" + memberName
				+ ", memberProfilePic=" + Arrays.toString(memberProfilePic) + ", msgContent=" + msgContent
				+ ", msgDate=" + msgDate + "]";
	}

	
}
