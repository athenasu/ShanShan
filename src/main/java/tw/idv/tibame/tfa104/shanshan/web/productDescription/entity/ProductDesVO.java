package tw.idv.tibame.tfa104.shanshan.web.productDescription.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "product_description")
public class ProductDesVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_des_id" ,  insertable= false, updatable= false)
	private Integer productDesId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "product_size")
	private Integer productSize;
	
	@Column(name = "product_color")
	private String productColor;
	
	@Column(name = "product_stock")
	private Integer productStock;
	
	@Column(name = "status")
	@ColumnDefault("0")
	private Integer status;
	
	@Column(name = "product_price")
	private Integer productPrice;
	
	@Transient
	private String picStr;
	
	


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
	
	public String getPicStr() {
		return picStr;
	}

	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}
	
	
}
