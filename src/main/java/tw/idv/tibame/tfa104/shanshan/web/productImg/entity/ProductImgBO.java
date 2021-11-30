package tw.idv.tibame.tfa104.shanshan.web.productImg.entity;

import java.io.Serializable;
import java.util.Arrays;
public class ProductImgBO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer product_img_id;
	private Integer product_des_id;
	private byte[] product_first_pic;
	private byte[] product_des_first_pic;
	private byte[] product_des_pic;
	
	
	public ProductImgBO() {
		super();
	}


	public ProductImgBO(Integer product_img_id, Integer product_des_id, byte[] product_first_pic,
			byte[] product_des_first_pic, byte[] product_des_pic) {
		super();
		this.product_img_id = product_img_id;
		this.product_des_id = product_des_id;
		this.product_first_pic = product_first_pic;
		this.product_des_first_pic = product_des_first_pic;
		this.product_des_pic = product_des_pic;
	}


	public Integer getProduct_img_id() {
		return product_img_id;
	}


	public void setProduct_img_id(Integer product_img_id) {
		this.product_img_id = product_img_id;
	}


	public Integer getProduct_des_id() {
		return product_des_id;
	}


	public void setProduct_des_id(Integer product_des_id) {
		this.product_des_id = product_des_id;
	}


	public byte[] getProduct_first_pic() {
		return product_first_pic;
	}


	public void setProduct_first_pic(byte[] product_first_pic) {
		this.product_first_pic = product_first_pic;
	}


	public byte[] getProduct_des_first_pic() {
		return product_des_first_pic;
	}


	public void setProduct_des_first_pic(byte[] product_des_first_pic) {
		this.product_des_first_pic = product_des_first_pic;
	}


	public byte[] getProduct_des_pic() {
		return product_des_pic;
	}


	public void setProduct_des_pic(byte[] product_des_pic) {
		this.product_des_pic = product_des_pic;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "ProductImgBO [product_img_id=" + product_img_id + ", product_des_id=" + product_des_id
				+ ", product_first_pic=" + Arrays.toString(product_first_pic) + ", product_des_first_pic="
				+ Arrays.toString(product_des_first_pic) + ", product_des_pic=" + Arrays.toString(product_des_pic)
				+ "]";
	}

}
