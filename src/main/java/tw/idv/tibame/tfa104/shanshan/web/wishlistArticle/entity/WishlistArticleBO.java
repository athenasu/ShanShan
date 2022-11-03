package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
public class WishlistArticleBO extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "wishlistArticleId")
	private Integer wishlistArticleId;
	@Column(name = "articleId")
	private Integer articleId;
	@Column(name = "articleTitle")
	private String articleTitle;
	@Column(name = "eventDate")
	private Date eventDate;
//	@Transient
	@Column(name = "articlePicture")
	private byte[] articlePicture;
	@Column(name = "memberName")
	private String memberName;
//	@Transient
	@Column(name = "memberProfilePicture")
	private byte[] memberProfilePicture;
	@Column(name = "mountainName")
	private String mountainName;
	@Transient
	private String articlePictureStr;
	@Transient
	private String memberPictureStr;

	public Integer getWishlistArticleId() {
		return wishlistArticleId;
	}

	public void setWishlistArticleId(Integer wishlistArticleId) {
		this.wishlistArticleId = wishlistArticleId;
	}

	public String getMountainName() {
		return mountainName;
	}

	public void setMountainName(String mountainName) {
		this.mountainName = mountainName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public byte[] getArticlePicture() {
		return articlePicture;
	}

	public void setArticlePicture(byte[] articlePicture) {
		this.articlePicture = articlePicture;
	}

	public byte[] getMemberProfilePicture() {
		return memberProfilePicture;
	}

	public void setMemberProfilePicture(byte[] memberProfilePicture) {
		this.memberProfilePicture = memberProfilePicture;
	}

	public String getArticlePictureStr() {
		return articlePictureStr;
	}

	public void setArticlePictureStr(String articlePictureStr) {
		this.articlePictureStr = articlePictureStr;
	}

	public String getMemberPictureStr() {
		return memberPictureStr;
	}

	public void setMemberPictureStr(String memberPictureStr) {
		this.memberPictureStr = memberPictureStr;
	}

}
