package tw.idv.tibame.tfa104.shanshan.web.member.entity;

import java.sql.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import tw.idv.tibame.tfa104.shanshan.Core;

@SqlResultSetMapping(
	name = "MemberWishlistArticle",
	classes = @ConstructorResult(
		targetClass = MemberWishlistArticle.class,
		columns = {
			@ColumnResult(name = "article_id"),
		    @ColumnResult(name = "article_title"),
		    @ColumnResult(name = "event_date"),
		    @ColumnResult(name = "member_name")
		}
	)
)

public class MemberWishlistArticle extends Core {
	private static final long serialVersionUID = 1L;

	private Integer articleId;
	private String articleTitle;
	private Date eventDate;
	private Byte[] articlePicture;
	private String memberName;
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
