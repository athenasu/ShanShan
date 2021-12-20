package tw.idv.tibame.tfa104.shanshan.web.admin.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class ArticleReportDetailBO extends Core{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "articleId")
	private Integer article_id;
	
	@Column(name = "articleReportId")
	private Integer article_report_id;
	
	@Column(name = "memberId")
	private Integer member_id;
	
	@Column(name = "articleTitle")
	private String article_title;
	
	@Column(name = "articleContent")
	private String article_content;
	
	@Column(name = "articleStatus")
	private Integer article_status;
	
	@Column(name = "articleReportReason")
	private Integer article_report_reason;
	
	@Column(name = "articleReportDate")
	private Timestamp article_report_date ;
	
	@Column(name = "caseDone")
	private Date case_done ;

	public Integer getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}

	public Integer getArticle_report_id() {
		return article_report_id;
	}

	public void setArticle_report_id(Integer article_report_id) {
		this.article_report_id = article_report_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public Integer getArticle_status() {
		return article_status;
	}

	public void setArticle_status(Integer article_status) {
		this.article_status = article_status;
	}

	public Integer getArticle_report_reason() {
		return article_report_reason;
	}

	public void setArticle_report_reason(Integer article_report_reason) {
		this.article_report_reason = article_report_reason;
	}

	public Timestamp getArticle_report_date() {
		return article_report_date;
	}

	public void setArticle_report_date(Timestamp article_report_date) {
		this.article_report_date = article_report_date;
	}

	public Date getCase_done() {
		return case_done;
	}

	public void setCase_done(Date case_done) {
		this.case_done = case_done;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArticleReportDetailBO [article_id=" + article_id + ", article_report_id=" + article_report_id
				+ ", member_id=" + member_id + ", article_title=" + article_title + ", article_content="
				+ article_content + ", article_status=" + article_status + ", article_report_reason="
				+ article_report_reason + ", article_report_date=" + article_report_date + ", case_done=" + case_done
				+ "]";
	}
}
