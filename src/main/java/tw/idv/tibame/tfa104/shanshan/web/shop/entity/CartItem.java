package tw.idv.tibame.tfa104.shanshan.web.shop.entity;

public class CartItem{

		private Integer productId; 
		private Integer prodesId; 
		private String productName; 
		private Integer companyId; 
		private String companyName; 
		private Integer productSize; 
		private String productColor; 
		private Integer productPrice; 
		private Integer itemQTY; 
		private Integer subtotalPrice;
		
//		set商品小計
		public void setSubtotalPrice() {
			this.subtotalPrice =  getSubtotalPrice();
		}

//		計算 商品小計
		public Integer getSubtotalPrice() {

			return getProductPrice() * getItemQTY();
		}
		
		public CartItem() {
			super();
		}
		
		
		public Integer getProdesId() {
			return prodesId;
		}

		public void setProdesId(Integer prodesId) {
			this.prodesId = prodesId;
		}

		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public Integer getProductSize() {
			return productSize;
		}
		public void setProductSize(Integer productSize) {
			this.productSize = productSize;
		}
		public String getProductColor() {
			return productColor;
		}
		public void setProductColor(String productColor) {
			this.productColor = productColor;
		}
		public Integer getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(Integer productPrice) {
			this.productPrice = productPrice;
		}
		public Integer getItemQTY() {
			return itemQTY;
		}
		public void setItemQTY(Integer itemQTY) {
			this.itemQTY = itemQTY;
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}

		public Integer getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}

		@Override
		public String toString() {
			return "CartItem [productId=" + productId + ", prodesId=" + prodesId + ", productName=" + productName
					+ ", companyId=" + companyId + ", companyName=" + companyName + ", productSize=" + productSize
					+ ", productColor=" + productColor + ", productPrice=" + productPrice + ", itemQTY=" + itemQTY
					+ ", subtotalPrice=" + subtotalPrice + "]";
		}

		public CartItem(Integer productId, Integer prodesId, String productName, Integer companyId, String companyName,
				Integer productSize, String productColor, Integer productPrice, Integer itemQTY,
				Integer subtotalPrice) {
			super();
			this.productId = productId;
			this.prodesId = prodesId;
			this.productName = productName;
			this.companyId = companyId;
			this.companyName = companyName;
			this.productSize = productSize;
			this.productColor = productColor;
			this.productPrice = productPrice;
			this.itemQTY = itemQTY;
			this.subtotalPrice = subtotalPrice;
		}


}
