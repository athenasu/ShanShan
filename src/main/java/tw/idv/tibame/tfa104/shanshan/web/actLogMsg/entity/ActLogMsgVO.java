package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity;

import java.sql.Date;

public class ActLogMsgVO {
	private Integer act_msg_id;
	private Integer article_id;
	private Integer member_id;
	private Date msg_time;
	private String msg_content;
	private Integer msg_status;
	
	public Integer getAct_msg_id() {
		return act_msg_id;
	}
	public void setAct_msg_id(Integer act_msg_id) {
		this.act_msg_id = act_msg_id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Date getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Date msg_time) {
		this.msg_time = msg_time;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Integer getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(Integer msg_status) {
		this.msg_status = msg_status;
	}
	
	

}
