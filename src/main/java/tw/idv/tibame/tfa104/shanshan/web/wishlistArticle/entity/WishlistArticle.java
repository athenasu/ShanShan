package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.Core;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;

@Entity
@Table(name = "wishlist_article")
public class WishlistArticle extends Core {

	private static final long serialVersionUID = 1L;

	private Integer wishlistArticleId;
	private Integer memberId;
	private Integer articleId;
	private Article article;

	@ManyToOne
	@JoinColumn(name ="article_id", referencedColumnName = "article_id")
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_article_id")
	public Integer getWishlistArticleId() {
		return wishlistArticleId;
	}

	public void setWishlistArticleId(Integer wishlistArticleId) {
		this.wishlistArticleId = wishlistArticleId;
	}

	@Column(name = "member_id")
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "article_id", insertable = false, updatable = false)
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

}
