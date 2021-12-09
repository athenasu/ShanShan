package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.entity.WishlistArticleBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.service.WishlistArticleService;


@RestController
@RequestMapping("wishlistArticle")
public class WishlistArticleController {

	@Autowired
	private WishlistArticleService wishlistService;

	@GetMapping("findWishlistArticlesByMemberId")
	public List<WishlistArticleBO> findWishlistArticle (Integer memberId){
		return wishlistService.findWishlistArticlesByMemberId(1);
	}
	
	@GetMapping("findAllWishlistArticlesByMemId")
	public List<WishlistArticle> findAllWishlistArticleByMemId(Integer memberId){
		return wishlistService.findAllWishlistArticleByMemId(memberId);
	}
	
	@PostMapping("addWishlistArticle")
	public Core addWishlistArticle(@RequestBody WishlistArticle wishlistArticle) { 
		Core core = new Core();
		boolean result = wishlistService.addWishlistArticle(wishlistArticle);
		if (result) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}
	
	@PostMapping("deleteWishlistArticle")
	public Core deleteWishlistArticle(@RequestBody WishlistArticle wishlistArticle) {
		Core core = new Core();
		boolean result = wishlistService.deleteWishlistArticle(wishlistArticle);
		if (result) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}
	
	@PostMapping("deleteWishlistArticleByMemIdArticleId")
	public Core deleteWishlistArticleByMemIdArticleId(@RequestBody WishlistArticle wishlistArticle) {
		Core core = new Core();
		boolean result = wishlistService.deleteWishlistArticleByMemIdEventId(wishlistArticle.getMemberId(), wishlistArticle.getArticleId());
		if(result) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}
}
