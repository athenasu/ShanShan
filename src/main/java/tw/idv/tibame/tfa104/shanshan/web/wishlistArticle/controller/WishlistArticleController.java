package tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return wishlistService.findWishlistArticlesByMemberId(memberId);
	}
	
	@PostMapping("addWishlistArticle")
	public boolean addWishlistArticle(@RequestBody WishlistArticle wishlistArticle) { 
		return wishlistService.addWishlistArticle(wishlistArticle);
	}
	
	@PostMapping("deleteWishlistArticle")
	public boolean deleteWishlistArticle(@RequestBody WishlistArticle wishlistArticle) {
		return wishlistService.deleteWishlistArticle(wishlistArticle);
	}
}
