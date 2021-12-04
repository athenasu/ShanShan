package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import tw.idv.tibame.tfa104.shanshan.Core;

@Entity
public class WishlistProductBO extends Core {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "wishlistProductId")
	private Integer wishlistProductId;
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "productName")
	private String productName;
//	@Transient
	@Column(name = "productImg")
	private byte[] productImg;
	@Column(name = "companyName")
	private String companyName;
//	@Transient
	@Column(name = "companyBanner")
	private byte[] companyBanner;
	@Transient
	private String productImgStr;
	@Transient
	private String companyBannerStr;

	public Integer getWishlistProductId() {
		return wishlistProductId;
	}

	public void setWishlistProductId(Integer wishlistProductId) {
		this.wishlistProductId = wishlistProductId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public byte[] getProductImg() {
		return productImg;
	}

	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public byte[] getCompanyBanner() {
		return companyBanner;
	}

	public void setCompanyBanner(byte[] companyBanner) {
		this.companyBanner = companyBanner;
	}

	public String getProductImgStr() {
		return productImgStr;
	}

	public void setProductImgStr(String productImgStr) {
		this.productImgStr = productImgStr;
	}

	public String getCompanyBannerStr() {
		return companyBannerStr;
	}

	public void setCompanyBannerStr(String companyBannerStr) {
		this.companyBannerStr = companyBannerStr;
	}

}
