package tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
@Table(name = "wishlist_product")
public class WishlistProduct extends Core {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wishlist_product_id")
	private Integer wishlistProductId;
	@Column(name = "member_id")
	private Integer memberId;
	@Column(name = "product_id")
	private Integer productId;

	
	public Integer getWishlistProductId() {
		return wishlistProductId;
	}

	public void setWishlistProductId(Integer wishlistProductId) {
		this.wishlistProductId = wishlistProductId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	
}
