package tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

public class OrderDescriptionBO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer order_id;
	
	private Integer member_id;
	
	private Date order_created_date;

	private String order_member_address;
	
	private String order_member_name;
	
	private Integer order_member_phone;
	
	private Integer order_status;
	
	private Integer order_sum_after;
	
	private Date order_shipped_date;
	
	private Integer ship_number;
	
	private Integer payment_status;
	
	private Integer product_id;
	
	private Integer prodes_id;
	
	private Integer company_id;
	
	private String company_name;
	
	private String product_name;
	
	private Integer product_size;
	
	private String product_color;
	
	private Integer order_description_price;
	
	private Integer subtotal_priece;
	
	private byte[] product_first_pic;

	
	public OrderDescriptionBO() {
		super();
	}


	public OrderDescriptionBO(Integer order_id, Integer member_id, Date order_created_date, String order_member_address,
			String order_member_name, Integer order_member_phone, Integer order_status, Integer order_sum_after,
			Date order_shipped_date, Integer ship_number, Integer payment_status, Integer product_id, Integer prodes_id,
			Integer company_id, String company_name, String product_name, Integer product_size, String product_color,
			Integer order_description_price, Integer subtotal_priece, byte[] product_first_pic) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.order_created_date = order_created_date;
		this.order_member_address = order_member_address;
		this.order_member_name = order_member_name;
		this.order_member_phone = order_member_phone;
		this.order_status = order_status;
		this.order_sum_after = order_sum_after;
		this.order_shipped_date = order_shipped_date;
		this.ship_number = ship_number;
		this.payment_status = payment_status;
		this.product_id = product_id;
		this.prodes_id = prodes_id;
		this.company_id = company_id;
		this.company_name = company_name;
		this.product_name = product_name;
		this.product_size = product_size;
		this.product_color = product_color;
		this.order_description_price = order_description_price;
		this.subtotal_priece = subtotal_priece;
		this.product_first_pic = product_first_pic;
	}


	public Integer getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}


	public Integer getMember_id() {
		return member_id;
	}


	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}


	public Date getOrder_created_date() {
		return order_created_date;
	}


	public void setOrder_created_date(Date order_created_date) {
		this.order_created_date = order_created_date;
	}


	public String getOrder_member_address() {
		return order_member_address;
	}


	public void setOrder_member_address(String order_member_address) {
		this.order_member_address = order_member_address;
	}


	public String getOrder_member_name() {
		return order_member_name;
	}


	public void setOrder_member_name(String order_member_name) {
		this.order_member_name = order_member_name;
	}


	public Integer getOrder_member_phone() {
		return order_member_phone;
	}


	public void setOrder_member_phone(Integer order_member_phone) {
		this.order_member_phone = order_member_phone;
	}


	public Integer getOrder_status() {
		return order_status;
	}


	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}


	public Integer getOrder_sum_after() {
		return order_sum_after;
	}


	public void setOrder_sum_after(Integer order_sum_after) {
		this.order_sum_after = order_sum_after;
	}


	public Date getOrder_shipped_date() {
		return order_shipped_date;
	}


	public void setOrder_shipped_date(Date order_shipped_date) {
		this.order_shipped_date = order_shipped_date;
	}


	public Integer getShip_number() {
		return ship_number;
	}


	public void setShip_number(Integer ship_number) {
		this.ship_number = ship_number;
	}


	public Integer getPayment_status() {
		return payment_status;
	}


	public void setPayment_status(Integer payment_status) {
		this.payment_status = payment_status;
	}


	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}


	public Integer getProdes_id() {
		return prodes_id;
	}


	public void setProdes_id(Integer prodes_id) {
		this.prodes_id = prodes_id;
	}


	public Integer getCompany_id() {
		return company_id;
	}


	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public Integer getProduct_size() {
		return product_size;
	}


	public void setProduct_size(Integer product_size) {
		this.product_size = product_size;
	}


	public String getProduct_color() {
		return product_color;
	}


	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}


	public Integer getOrder_description_price() {
		return order_description_price;
	}


	public void setOrder_description_price(Integer order_description_price) {
		this.order_description_price = order_description_price;
	}


	public Integer getSubtotal_priece() {
		return subtotal_priece;
	}


	public void setSubtotal_priece(Integer subtotal_priece) {
		this.subtotal_priece = subtotal_priece;
	}


	public byte[] getProduct_first_pic() {
		return product_first_pic;
	}


	public void setProduct_first_pic(byte[] product_first_pic) {
		this.product_first_pic = product_first_pic;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "OrderDescriptionBO [order_id=" + order_id + ", member_id=" + member_id + ", order_created_date="
				+ order_created_date + ", order_member_address=" + order_member_address + ", order_member_name="
				+ order_member_name + ", order_member_phone=" + order_member_phone + ", order_status=" + order_status
				+ ", order_sum_after=" + order_sum_after + ", order_shipped_date=" + order_shipped_date
				+ ", ship_number=" + ship_number + ", payment_status=" + payment_status + ", product_id=" + product_id
				+ ", prodes_id=" + prodes_id + ", company_id=" + company_id + ", company_name=" + company_name
				+ ", product_name=" + product_name + ", product_size=" + product_size + ", product_color="
				+ product_color + ", order_description_price=" + order_description_price + ", subtotal_priece="
				+ subtotal_priece + ", product_first_pic=" + Arrays.toString(product_first_pic) + "]";
	}




}
