package tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity;

import java.io.Serializable;

public class OrderDescription implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer order_des_id;
	private Integer product_des_id;
	private Integer order_id;
	private Integer product_quantity;
	private Integer product_price;
	
	public OrderDescription() {
	}

	public OrderDescription(Integer order_des_id, Integer product_des_id, Integer order_id, Integer product_quantity,
			Integer product_price) {
		super();
		this.order_des_id = order_des_id;
		this.product_des_id = product_des_id;
		this.order_id = order_id;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
	}

	public Integer getOrder_des_id() {
		return order_des_id;
	}

	public void setOrder_des_id(Integer order_des_id) {
		this.order_des_id = order_des_id;
	}

	public Integer getProduct_des_id() {
		return product_des_id;
	}

	public void setProduct_des_id(Integer product_des_id) {
		this.product_des_id = product_des_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(Integer product_quantity) {
		this.product_quantity = product_quantity;
	}

	public Integer getProduct_price() {
		return product_price;
	}

	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "OrderDescription [order_des_id=" + order_des_id + ", product_des_id=" + product_des_id + ", order_id="
				+ order_id + ", product_quantity=" + product_quantity + ", product_price=" + product_price + "]";
	}
	

}
