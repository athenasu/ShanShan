package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProductBO;

public interface WishlistProductService {
	
	public Boolean addWishlistProduct(WishlistProduct wishlistProduct);
	public Boolean deleteWishlistProduct(WishlistProduct wishlistProduct);
	public Boolean deleteWishlistProductMemIdProductId(Integer memberId, Integer productId);
	public List<WishlistProductBO> findWishlistProductsByMemberId(Integer memberId);
}
