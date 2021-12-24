package tw.idv.tibame.tfa104.shanshan.web.product.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@Entity
@DynamicInsert
@Table(name = "product")
public class Product extends Core {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id",  insertable= false, updatable= false)
	private Integer productId;
	
	@Column(name = "product_type")
	private Integer productType;
	
	
	//如果前端傳入的預設值是0，要載入DynamicInsert 跟ColumnDefault 這兩個annotation
	@Column(name = "status")
	@ColumnDefault("0")
	private Integer status;
	
	@Column(name = "product_price")
	private Integer productPrice;
	
	@Column(name = "product_intro")
	private String productIntro;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "company_id")
	private Integer companyId;


	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	
	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
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

	
	public String getProductIntro() {
		return productIntro;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}

	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", status=" + status
				+ ", productPrice=" + productPrice + ", productIntro=" + productIntro + ", productName=" + productName
				+ ", companyId=" + companyId + "]";
	}
	
	


	

}
