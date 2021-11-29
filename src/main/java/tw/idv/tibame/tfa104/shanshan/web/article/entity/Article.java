package tw.idv.tibame.tfa104.shanshan.web.article.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private Date articleDateCreated;
	@Column(name = "event_date")
	private Date eventDate;
	@Column(name = "recommendation")
	private Integer recommendation;
	@Transient
	@Column(name = "article_points_received")
	private Integer articlePointsReceived;
	@Column(name = "article_status")
	private Integer articleStatus;
	@Transient
	@Column(name = "article_viewer")
	private Integer articleViewer;
	@Column(name = "other_mtn")
	private String otherMtn;

//	@JoinColumn(name = "article_id", referencedColumnName = "article_id")
//	@OneToMany
//	private List<ArticlePicture> pictures;
//	
//	public List<ArticlePicture> getPictures() {
//		return pictures;
//	}
//
//	public void setPictures(List<ArticlePicture> pictures) {
//		this.pictures = pictures;
//	}

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

	public Date getArticleDateCreated() {
		return articleDateCreated;
	}

	public void setArticleDateCreated(Date articleDateCreated) {
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

	public Integer getArticlePointsReceived() {
		return articlePointsReceived;
	}

	public void setArticlePointsReceived(Integer articlePointsReceived) {
		this.articlePointsReceived = articlePointsReceived;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public Integer getArticleViewer() {
		return articleViewer;
	}

	public void setArticleViewer(Integer articleViewer) {
		this.articleViewer = articleViewer;
	}

	public String getOtherMtn() {
		return otherMtn;
	}

	public void setOtherMtn(String otherMtn) {
		this.otherMtn = otherMtn;
	}

}
