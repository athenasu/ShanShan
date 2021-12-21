package tw.idv.tibame.tfa104.shanshan.web.admin.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class ArticleReportBO extends Core{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "articleReportId")
	private Integer articleReportId;
	
	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "articleId")
	private Integer articleId;
	
	@Column(name = "articleReportStatus")
	private Integer articleReportStatus;
	
	@Column(name = "articleReportReason")
	private Integer articleReportReason;
	
	@Column(name = "articleReportDate")
	private Timestamp articleReportDate;
	
	@Column(name = "caseDone")
	private Date caseDone;

	public Integer getArticleReportId() {
		return articleReportId;
	}

	public void setArticleReportId(Integer articleReportId) {
		this.articleReportId = articleReportId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getArticletId() {
		return articleId;
	}

	public void setArticletId(Integer articletId) {
		this.articleId = articletId;
	}

	public Integer getArticleReportStatus() {
		return articleReportStatus;
	}

	public void setArticleReportStatus(Integer articleReportStatus) {
		this.articleReportStatus = articleReportStatus;
	}

	public Integer getArticleReportReason() {
		return articleReportReason;
	}

	public void setArticleReportReason(Integer articleReportReason) {
		this.articleReportReason = articleReportReason;
	}

	public Timestamp getArticleReportDate() {
		return articleReportDate;
	}

	public void setArticleReportDate(Timestamp articleReportDate) {
		this.articleReportDate = articleReportDate;
	}

	public Date getCaseDone() {
		return caseDone;
	}

	public void setCaseDone(Date caseDone) {
		this.caseDone = caseDone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArticleReportBO [articleReportId=" + articleReportId + ", memberId=" + memberId + ", articleId="
				+ articleId + ", articleReportStatus=" + articleReportStatus + ", articleReportReason="
				+ articleReportReason + ", articleReportDate=" + articleReportDate + ", caseDone=" + caseDone + "]";
	}
}
