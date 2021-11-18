package tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity;

public class Order_description {
	private int order_des_id;
	private int product_des_id;
	private int order_id;
	private int product_quantity;
	private int product_price;

	public Order_description() {
	}
	
	public Order_description(int order_des_id, int product_des_id, int order_id, int product_quantity,
			int product_price) {
		super();
		this.order_des_id = order_des_id;
		this.product_des_id = product_des_id;
		this.order_id = order_id;
		this.product_quantity = product_quantity;
		this.product_price = product_price;
	}



	public int getOrder_des_id() {
		return order_des_id;
	}
	public void setOrder_des_id(int order_des_id) {
		this.order_des_id = order_des_id;
	}
	public int getProduct_des_id() {
		return product_des_id;
	}
	public void setProduct_des_id(int product_des_id) {
		this.product_des_id = product_des_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	@Override
	public String toString() {
		return "order_description [order_des_id=" + order_des_id + ", product_des_id=" + product_des_id + ", order_id="
				+ order_id + ", product_quantity=" + product_quantity + ", product_price=" + product_price + "]";
	}

	
}
