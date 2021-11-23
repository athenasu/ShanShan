package tw.idv.tibame.tfa104.shanshan.web.article.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePicture;

@Entity
@Table(name = "article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer article_id;
	private Integer member_id;
	private Integer mountain_id;
	private String article_title;
	private String article_content;
	private Date article_date_created;
	private Date event_date;
	private Integer recommendation;
	@Transient
	private Integer article_points_received;
	private Integer article_status;
	@Transient
	private Integer article_viewer;
	private String other_mtn;
	
	@JoinColumn(name = "article_id", referencedColumnName = "article_id")
	@OneToMany
	private List<ArticlePicture> pictures;
	
	public List<ArticlePicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<ArticlePicture> pictures) {
		this.pictures = pictures;
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

	public Integer getMountain_id() {
		return mountain_id;
	}

	public void setMountain_id(Integer mountain_id) {
		this.mountain_id = mountain_id;
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

	public Date getArticle_date_created() {
		return article_date_created;
	}

	public void setArticle_date_created(Date article_date_created) {
		this.article_date_created = article_date_created;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public Integer getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Integer recommendation) {
		this.recommendation = recommendation;
	}

	public Integer getArticle_points_received() {
		return article_points_received;
	}

	public void setArticle_points_received(Integer article_points_received) {
		this.article_points_received = article_points_received;
	}

	public Integer getArticle_status() {
		return article_status;
	}

	public void setArticle_status(Integer article_status) {
		this.article_status = article_status;
	}

	public Integer getArticle_viewer() {
		return article_viewer;
	}

	public void setArticle_viewer(Integer article_viewer) {
		this.article_viewer = article_viewer;
	}

	public String getOther_mtn() {
		return other_mtn;
	}

	public void setOther_mtn(String other_mtn) {
		this.other_mtn = other_mtn;
	}

}
