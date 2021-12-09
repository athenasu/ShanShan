package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.dao.WishlistArticleDao;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticleBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.service.WishlistArticleService;

@Service
@Transactional
public class WishlistArticleServiceImpl implements WishlistArticleService {
	
	@Autowired
	private WishlistArticleDao dao;
	
	@Override
	public Boolean deleteWishlistArticle(WishlistArticle wishlistArticle) {
		int result = dao.deleteWishlistArticle(wishlistArticle);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean deleteWishlistArticleByMemIdEventId(Integer memberId, Integer articleId) {
		int result = dao.deleteWishlistArticleByMemIdEventId(memberId, articleId);
		if (result >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@Override
	public  List<WishlistArticleBO> findWishlistArticlesByMemberId(Integer memberId) {
		List<WishlistArticleBO> wishlistArticles = dao.findWishlistArticlesByMemberId(memberId);
		// changing the article picture & member picture to a string
		for (WishlistArticleBO wishlistArticle : wishlistArticles) {
			wishlistArticle.setArticlePictureStr(Base64.getEncoder().encodeToString(wishlistArticle.getArticlePicture()));
			wishlistArticle.setMemberPictureStr(Base64.getEncoder().encodeToString(wishlistArticle.getMemberProfilePicture()));
		}
		return wishlistArticles;
	}
	
	@Override
	public List<WishlistArticle> findAllWishlistArticleByMemId(Integer memberId) {
		return dao.findAllWishlistArticleByMemId(memberId);
	}
	
	@Override
	public Boolean addWishlistArticle(WishlistArticle wishlistArticle) {
		boolean result = dao.addWishlistArticle(wishlistArticle);
		if (result) {
			wishlistArticle.setSuccessful(true);
			return true;
		} else {
			wishlistArticle.setSuccessful(false);
			return false;
		}
	}
}
