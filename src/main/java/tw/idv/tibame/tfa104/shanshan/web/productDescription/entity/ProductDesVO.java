package tw.idv.tibame.tfa104.shanshan.web.productDescription.entity;

import java.io.Serializable;

public class ProductDesVO implements Serializable{

	private Integer productDesId;
	private Integer productId;
	private Integer productSize;
	private String productColor;
	private Integer productStock;
	private Integer status;
	private Integer productPrice;
	
	public ProductDesVO() {
		super();
	}
	
	public Integer getProductDesId() {
		return productDesId;
	}
	public void setProductDesId(Integer productDesId) {
		this.productDesId = productDesId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
	
}
