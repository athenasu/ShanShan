package tw.idv.tibame.tfa104.shanshan.web.admin.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class Article extends Core{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "article_id")
	private Integer articleId;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "mountain_id")
	private Integer mountainId;
	
	@Column(name = "article_title")
	private String articleTitle;
	
	@Column(name = "article_content")
	private String articleContent;
	
	@Column(name = "article_date_created")
	private Timestamp articleDateCreated;
	
	@Column(name = "event_date")
	private Date eventDate;
	
	@Column(name = "recommendation")
	private Integer recommendation;
	
	@Column(name = "article_points_recieved")
	private Integer articlePointsRecieved;
	
	@Column(name = "article_status")
	private Integer articleStatus;
	
	@Column(name = "aritcle_viewer")
	private Integer aritcleViewer;
	
	@Column(name = "other_mtn")
	private String otherMtn;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getMountainId() {
		return mountainId;
	}

	public void setMountainId(Integer mountainId) {
		this.mountainId = mountainId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Timestamp getArticleDateCreated() {
		return articleDateCreated;
	}

	public void setArticleDateCreated(Timestamp articleDateCreated) {
		this.articleDateCreated = articleDateCreated;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Integer recommendation) {
		this.recommendation = recommendation;
	}

	public Integer getArticlePointsRecieved() {
		return articlePointsRecieved;
	}

	public void setArticlePointsRecieved(Integer articlePointsRecieved) {
		this.articlePointsRecieved = articlePointsRecieved;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public Integer getAritcleViewer() {
		return aritcleViewer;
	}

	public void setAritcleViewer(Integer aritcleViewer) {
		this.aritcleViewer = aritcleViewer;
	}

	public String getOtherMtn() {
		return otherMtn;
	}

	public void setOtherMtn(String otherMtn) {
		this.otherMtn = otherMtn;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", memberId=" + memberId + ", mountainId=" + mountainId
				+ ", articleTitle=" + articleTitle + ", articleContent=" + articleContent + ", articleDateCreated="
				+ articleDateCreated + ", eventDate=" + eventDate + ", recommendation=" + recommendation
				+ ", articlePointsRecieved=" + articlePointsRecieved + ", articleStatus=" + articleStatus
				+ ", aritcleViewer=" + aritcleViewer + ", otherMtn=" + otherMtn + "]";
	}
}
