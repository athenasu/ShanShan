package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticleBO;

public interface WishlistArticleDao {

	// select: find all WishlistArticleBOs by memberId (for member wishlist)
	public List<WishlistArticleBO> findWishlistArticlesByMemberId(Integer memberId);
	// select: find all WishlistArticles by memberId
	public List<WishlistArticle> findAllWishlistArticleByMemId(Integer memberId);
	// create: add wishlistArticle by memberId & articleId
	public Boolean addWishlistArticle(WishlistArticle wishlistArticle);
	// delete: delete wishlistArticle by wishlistArticleId
	public Integer deleteWishlistArticle(WishlistArticle wishlistArticle);
	// delete: delete wishlistArticle by memberId and articleId
	public Integer deleteWishlistArticleByMemIdEventId(Integer memberId, Integer articleId);
	
}
