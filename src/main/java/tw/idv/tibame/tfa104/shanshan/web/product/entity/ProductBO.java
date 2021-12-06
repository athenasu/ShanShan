package tw.idv.tibame.tfa104.shanshan.web.product.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProductBO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "productId")
	private Integer productId;
	
	@Column(name = "prodesId")
	private Integer prodesId;
	
	@Column(name = "companyId")
	private Integer companyId;
	
	@Column(name = "companyName")
	private String companyName;
	
	@Column(name = "companyIntro")
	private String companyIntro;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productType")
	private Integer productType;
	
	@Column(name = "productSize")
	private Integer productSize;
	
	@Column(name = "productColor")
	private String productColor;
	
	@Column(name = "productPrice")
	private Integer productPrice;
	
	@Column(name = "proDesStock")
	private Integer proDesStock;
	
	@Column(name = "productIntro")
	private String productIntro;
	
	@Column(name = "status")
	private Integer status;
	
	@Transient
//	@Column(name = "productImg")
	private byte[] productImg;
	
	@Transient
	private String picStr;
	
	
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
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyIntro() {
		return companyIntro;
	}
	public void setCompanyIntro(String companyIntro) {
		this.companyIntro = companyIntro;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductType() {
		return productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
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
	public String getProductIntro() {
		return productIntro;
	}
	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public byte[] getProductImg() {
		return productImg;
	}
	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}
	public String getPicStr() {
		return picStr;
	}
	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}
	
	
	@Override
	public String toString() {
		return "ProductBO [productId=" + productId + ", prodesId=" + prodesId + ", companyName=" + companyName
				+ ", companyIntro=" + companyIntro + ", productName=" + productName + ", productType=" + productType
				+ ", productSize=" + productSize + ", productColor=" + productColor + ", productPrice=" + productPrice
				+ ", proDesStock=" + proDesStock + ", productIntro=" + productIntro + ", status=" + status
				+ ", productImg=" + Arrays.toString(productImg) + ", picStr=" + picStr + "]";
	}
	
	
	
}
