package tw.idv.tibame.tfa104.shanshan.web.order.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.CartItem;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<OrderDescriptionBO> orderDesBOList= new ArrayList<OrderDescriptionBO>();
	private Integer order_id;
	private Integer member_id;
	private Integer company_id;
	private Date order_created_date;
	private String order_member_address;
	private String order_member_name;
	private Integer order_member_phone;
	
	private Integer order_status;
	private Integer point_used;
	private Integer order_sum_before;
	private Integer order_sum_after;
	private Date order_shipped_date;
	private Integer ship_number;
	private Integer payment_status;
	
	public Order() {
	}


//	public Collection<CartItem> getCartItems() {
//		return mapCartItem.values();
//	}

//	EL表達式中，取值的方法是透過物件的get方法，去掉get,屬性名改小寫，取到該get方法的值。
	public List<OrderDescriptionBO> getOrderDesBOList() {
		return orderDesBOList;
	}

	public void setOrderDesBOList(List<OrderDescriptionBO> orderDesBOList) {
		this.orderDesBOList = orderDesBOList;
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

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
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

	public Integer getPoint_used() {
		return point_used;
	}

	public void setPoint_used(Integer point_used) {
		this.point_used = point_used;
	}

	public Integer getOrder_sum_before() {
		return order_sum_before;
	}

	public void setOrder_sum_before(Integer order_sum_before) {
		this.order_sum_before = order_sum_before;
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

	@Override
	public String toString() {
		return "Order [orderDesBOList=" + orderDesBOList + ", order_id=" + order_id + ", member_id=" + member_id + ", company_id="
				+ company_id + ", order_created_date=" + order_created_date + ", order_member_address="
				+ order_member_address + ", order_member_name=" + order_member_name + ", order_member_phone="
				+ order_member_phone + ", order_status=" + order_status + ", point_used=" + point_used
				+ ", order_sum_before=" + order_sum_before + ", order_sum_after=" + order_sum_after
				+ ", order_shipped_date=" + order_shipped_date + ", ship_number=" + ship_number + ", payment_status="
				+ payment_status + "]";
	}

	public Order(List<OrderDescriptionBO> orderDesBOList, Integer order_id, Integer member_id, Integer company_id,
			Date order_created_date, String order_member_address, String order_member_name, Integer order_member_phone,
			Integer order_status, Integer point_used, Integer order_sum_before, Integer order_sum_after,
			Date order_shipped_date, Integer ship_number, Integer payment_status) {
		super();
		this.orderDesBOList = orderDesBOList;
		this.order_id = order_id;
		this.member_id = member_id;
		this.company_id = company_id;
		this.order_created_date = order_created_date;
		this.order_member_address = order_member_address;
		this.order_member_name = order_member_name;
		this.order_member_phone = order_member_phone;
		this.order_status = order_status;
		this.point_used = point_used;
		this.order_sum_before = order_sum_before;
		this.order_sum_after = order_sum_after;
		this.order_shipped_date = order_shipped_date;
		this.ship_number = ship_number;
		this.payment_status = payment_status;
	}

}
