package tw.idv.tibame.tfa104.shanshan.web.productDescription.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FindByProductIdBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name = "productId")
	private Integer productId;
	
	@Column(name = "prodesId")
	private Integer prodesId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productSize")
	private Integer productSize;
	
	@Column(name = "productType")
	private Integer productType;
	
	@Column(name = "productColor")
	private String productColor;
	
	@Column(name = "productPrice")
	private Integer productPrice;
	
	@Column(name = "proDesStock")
	private Integer proDesStock;
	
	@Column(name = "productImg")
	private byte[] productImg;
	
	@Column(name = "productImgId")
	private Integer productImgId;
	
	@Column(name = "productIntro")
	private String productIntro;
	
	@Column(name = "status")
	private Integer status;
	
	@Transient
	private String picStr;
	
	public FindByProductIdBO() {
		super();
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public Integer getProDesStock() {
		return proDesStock;
	}
	public void setProDesStock(Integer proDesStock) {
		this.proDesStock = proDesStock;
	}
	public byte[] getProductImg() {
		return productImg;
	}
	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}
	public String getProductIntro() {
		return productIntro;
	}
	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getPicStr() {
		return picStr;
	}

	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}
	
	public Integer getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}
	@Override
	public String toString() {
		return "FindByProductIdBO [productId=" + productId + ", prodesId=" + prodesId + ", productName=" + productName
				+ ", productSize=" + productSize + ", productColor=" + productColor + ", productPrice=" + productPrice
				+ ", proDesStock=" + proDesStock + ", productImg=" + Arrays.toString(productImg) + ", productIntro="
				+ productIntro + ", picStr=" + picStr + "]";
	}
	
	
}
