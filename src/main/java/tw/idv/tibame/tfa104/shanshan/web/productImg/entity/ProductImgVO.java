package tw.idv.tibame.tfa104.shanshan.web.productImg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_img")
public class ProductImgVO implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productImgId;
	
	@Column(name = "product_des_id")
	private Integer productDesId;
	
	@Column(name = "product_img", columnDefinition = "LONGBLOB")
	private byte[] productImg;
	
	public ProductImgVO() {
		super();
	}
	
	
	public Integer getProductImgId() {
		return productImgId;
	}
	
	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}
	
	
	public Integer getProductDesId() {
		return productDesId;
	}
	
	public void setProductDesId(Integer productDesId) {
		this.productDesId = productDesId;
	}
	
	
	public byte[] getProductImg() {
		return productImg;
	}
	
	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

}
