package tw.idv.tibame.tfa104.shanshan.web.shop.entity;

public class CartItem{

		private Integer productId; 
		private String productName; 
		private String companyName; 
		private Integer productSize; 
		private String productColor; 
		private double productPrice; 
		private Integer itemQTY; 
		private double subtotalPrice;
		
//		獲取商品小計
		public double getSubtotalPrice() {
			return getProductPrice() * getItemQTY();
		}
		
		public CartItem() {
			super();
		}
		
		
		public CartItem(Integer productId, String productName, String companyName, Integer productSize,
				String productColor, double productPrice, Integer itemQTY) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.companyName = companyName;
			this.productSize = productSize;
			this.productColor = productColor;
			this.productPrice = productPrice;
			this.itemQTY = itemQTY;
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
		public double getProductPrice() {
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
		public void setSubtotalPrice(Integer subtotalPrice) {
			this.subtotalPrice = subtotalPrice;
		}
		@Override
		public String toString() {
			return "CartItem [productId=" + productId + ", productName=" + productName + ", companyName=" + companyName
					+ ", productSize=" + productSize + ", productColor=" + productColor + ", productPrice="
					+ productPrice + ", itemQTY=" + itemQTY + ", subtotalPrice=" + subtotalPrice + "]";
		} 
		
		
}
