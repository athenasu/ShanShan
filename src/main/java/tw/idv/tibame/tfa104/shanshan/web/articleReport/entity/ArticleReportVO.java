package tw.idv.tibame.tfa104.shanshan.web.articleReport.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class ArticleReportVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer article_report_id;
	private Integer member_id;
	private Integer article_id;
	private Integer article_report_status;
	private Integer article_report_reason;
	private Timestamp article_report_date ;
	private Date case_done ;
	
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
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getArticle_report_status() {
		return article_report_status;
	}
	public void setArticle_report_status(Integer article_report_status) {
		this.article_report_status = article_report_status;
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
	
	
	

}
