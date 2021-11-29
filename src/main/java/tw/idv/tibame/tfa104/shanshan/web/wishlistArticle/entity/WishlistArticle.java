package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
@Table(name = "wishlist_article")
public class WishlistArticle extends Core {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_article_id")
	private Integer wishlistArticleId;
	@Column(name = "article_id")
	private Integer articleId;
	@Column(name = "member_id")
	private Integer memberId;

//	private Article article;
//
//	@ManyToOne
//	@JoinColumn(name ="article_id", referencedColumnName = "article_id", insertable = false, updatable = false) // we add the insertable & updatable here because it's getting mixed up with the other article_id column
//	public Article getArticle() {
//		return article;
//	}
//
//	public void setArticle(Article article) {
//		this.article = article;
//	}

	public Integer getWishlistArticleId() {
		return wishlistArticleId;
	}

	public void setWishlistArticleId(Integer wishlistArticleId) {
		this.wishlistArticleId = wishlistArticleId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

//	

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

}
