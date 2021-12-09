package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.dao.WishlistProductDao;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProductBO;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service.WishlistProductService;

@Service
@Transactional
public class WishlistProductServiceImpl implements WishlistProductService {
	
	@Autowired
	private WishlistProductDao dao;
	
	@Override
	public List<WishlistProductBO> findWishlistProductsByMemberId(Integer memberId){
		List<WishlistProductBO> wishlistProducts = dao.findWishlistProductsByMemberId(memberId);
		for (WishlistProductBO wishlistProduct : wishlistProducts) {
			wishlistProduct.setProductImgStr(Base64.getEncoder().encodeToString(wishlistProduct.getProductImg()));
			wishlistProduct.setCompanyBannerStr(Base64.getEncoder().encodeToString(wishlistProduct.getCompanyBanner()));
		}
		return wishlistProducts;
	}
	
	public Boolean deleteWishlistProductMemIdProductId(Integer memberId, Integer productId) {
		int result = dao.deleteWishlistProductMemIdProductId(memberId, productId);
		if (result >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean deleteWishlistProduct(WishlistProduct wishlistProduct) {
		int result = dao.deleteWishlistProduct(wishlistProduct);
		if (result == 1) {
			wishlistProduct.setSuccessful(true);
			return true;
		} else {
			wishlistProduct.setSuccessful(true);
			return false;
		}
	}
	
	@Override
	public Boolean addWishlistProduct(WishlistProduct wishlistProduct) {
		int result = dao.addWishlistProduct(wishlistProduct);
		if (result > 0) {
			wishlistProduct.setSuccessful(true);
			return true;
		} else {
			wishlistProduct.setSuccessful(false);
			return false;
		}
	}
}
