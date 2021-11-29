package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProductBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service.WishlistProductService;


@RestController
@RequestMapping("wishlistProduct")
public class WishlistProductController {

	@Autowired
	private WishlistProductService wishlistService;
	
	// it's not working with PostMapping (I can't put stuff in), 
	// so I'm using GetMapping. Will this be a problem? (have to check WishlistAritcle because that one is PostMapping)
	@GetMapping("findWishlistProductsByMemberId")
	public List<WishlistProductBO> findWishlistProductsByMemberId(Integer memberId){
		return wishlistService.findWishlistProductsByMemberId(memberId);
	}
	
	@PostMapping("deleteWishlistProduct")
	public Boolean deleteWishlistProduct(@RequestBody WishlistProduct wishlistProduct) {
		return wishlistService.deleteWishlistProduct(wishlistProduct);
	}

	@PostMapping("addWishlistProduct")
	public Boolean addWishlistProduct(@RequestBody WishlistProduct wishlistProduct) { 
		return wishlistService.addWishlistProduct(wishlistProduct);
	}
}
