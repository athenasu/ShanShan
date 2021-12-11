package tw.idv.tibame.tfa104.shanshan.web.article.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class ArticleVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer article_id;
	private Integer member_id;
	private Integer mountain_id;
	private String article_title;
	private String article_content;
	private Date article_date_created;
	private Date event_date;
	private Integer recommendation;
	private Integer Article_points_recieved;
	private Integer article_status;
	private Integer aritcle_viewer;
	private String other_mtn;
	private String picString;

	public String getPicString() {
		return picString;
	}

	public void setPicString(String picString) {
		this.picString = picString;
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

	public Integer getArticle_points_recieved() {
		return Article_points_recieved;
	}

	public void setArticle_points_recieved(Integer Article_points_recieved) {
		this.Article_points_recieved = Article_points_recieved;
	}

	public Integer getArticle_status() {
		return article_status;
	}

	public void setArticle_status(Integer article_status) {
		this.article_status = article_status;
	}

	public Integer getAritcle_viewer() {
		return aritcle_viewer;
	}

	public void setAritcle_viewer(Integer aritcle_viewer) {
		this.aritcle_viewer = aritcle_viewer;
	}

	public String getOther_mtn() {
		return other_mtn;
	}

	public void setOther_mtn(String other_mtn) {
		this.other_mtn = other_mtn;
	}

//	for join
	private Integer mountain_district;
	private String mountain_name;
	private BigDecimal mountain_longitude;
	private BigDecimal mountain_latitude;
	private Integer article_picture_id;
	private byte[] article_picture;
	private String member_name;

	
	
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public Integer getMountain_district() {
		return mountain_district;
	}

	public void setMountain_district(Integer mountain_district) {
		this.mountain_district = mountain_district;
	}

	public String getMountain_name() {
		return mountain_name;
	}

	public void setMountain_name(String mountain_name) {
		this.mountain_name = mountain_name;
	}

	public BigDecimal getMountain_longitude() {
		return mountain_longitude;
	}

	public void setMountain_longitude(BigDecimal mountain_longitude) {
		this.mountain_longitude = mountain_longitude;
	}

	public BigDecimal getMountain_latitude() {
		return mountain_latitude;
	}

	public void setMountain_latitude(BigDecimal mountain_latitude) {
		this.mountain_latitude = mountain_latitude;
	}

	public Integer getArticle_picture_id() {
		return article_picture_id;
	}

	public void setArticle_picture_id(Integer article_picture_id) {
		this.article_picture_id = article_picture_id;
	}

	public byte[] getArticle_picture() {
		return article_picture;
	}

	public void setArticle_picture(byte[] article_picture) {
		this.article_picture = article_picture;
	}

}
