package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProductBO;

public interface WishlistProductDao {

	public Integer addWishlistProduct(WishlistProduct wishlistProduct);
	public Integer deleteWishlistProduct(WishlistProduct wishlistProduct);
	public List<WishlistProductBO> findWishlistProductsByMemberId(Integer memberId);
}
