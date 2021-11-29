package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticleBO;

public interface WishlistArticleDao {

	public List<WishlistArticleBO> findWishlistArticlesByMemberId(Integer memberId);
	public Boolean addWishlistArticle(WishlistArticle wishlistArticle);
	public Integer deleteWishlistArticle(WishlistArticle wishlistArticle); 
	
}
