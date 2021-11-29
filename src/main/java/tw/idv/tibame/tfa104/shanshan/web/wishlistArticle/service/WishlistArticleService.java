package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticleBO;

public interface WishlistArticleService {
	
	public List<WishlistArticleBO> findWishlistArticlesByMemberId(Integer memberId);
	public boolean addWishlistArticle(WishlistArticle wishlistArticle);
	public boolean deleteWishlistArticle(WishlistArticle wishlistArticle);

}
