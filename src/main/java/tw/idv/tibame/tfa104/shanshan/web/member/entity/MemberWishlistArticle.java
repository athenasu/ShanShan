package tw.idv.tibame.tfa104.shanshan.web.member.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class MemberWishlistArticle extends Core {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer articleId;
	private String articleTitle;
	private Date eventDate;
	@Transient
	private Byte[] articlePicture;
	private String memberName;
	@Transient
	private Byte[] memberProfilePicture;

	public  String getMemberName() {
		return memberName;
	}

	public void setMemberName( String memberName) {
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

	public Byte[] getArticlePicture() {
		return articlePicture;
	}

	public void setArticlePicture(Byte[] articlePicture) {
		this.articlePicture = articlePicture;
	}

	public Byte[] getMemberProfilePicture() {
		return memberProfilePicture;
	}

	public void setMemberProfilePicture(Byte[] memberProfilePicture) {
		this.memberProfilePicture = memberProfilePicture;
	}

}
