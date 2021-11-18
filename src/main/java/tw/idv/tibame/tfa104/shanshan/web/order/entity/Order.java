package tw.idv.tibame.tfa104.shanshan.web.order.entity;

import java.sql.Date;

public class Order {

	private int order_id;
	private int member_id;
	private Date order_created_date;
	private String order_member_address;
	private String order_member_name;
	private int order_member_phone;
	private int order_status;
	private int point_used;
	private int order_sum_before;
	private int order_sum_after;
	private Date order_shipped_date;
	private int ship_number;
	private int payment_status;
	
	public Order() {
	}
	
	public Order(int order_id, int member_id, Date order_created_date, String order_member_address,
			String order_member_name, int order_member_phone, int order_status, int point_used, int order_sum_before,
			int order_sum_after, Date order_shipped_date, int ship_number, int payment_status) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
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

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
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
	public int getOrder_member_phone() {
		return order_member_phone;
	}
	public void setOrder_member_phone(int order_member_phone) {
		this.order_member_phone = order_member_phone;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
	public int getPoint_used() {
		return point_used;
	}
	public void setPoint_used(int point_used) {
		this.point_used = point_used;
	}
	public int getOrder_sum_before() {
		return order_sum_before;
	}
	public void setOrder_sum_before(int order_sum_before) {
		this.order_sum_before = order_sum_before;
	}
	public int getOrder_sum_after() {
		return order_sum_after;
	}
	public void setOrder_sum_after(int order_sum_after) {
		this.order_sum_after = order_sum_after;
	}
	public Date getOrder_shipped_date() {
		return order_shipped_date;
	}
	public void setOrder_shipped_date(Date order_shipped_date) {
		this.order_shipped_date = order_shipped_date;
	}
	public int getShip_number() {
		return ship_number;
	}
	public void setShip_number(int ship_number) {
		this.ship_number = ship_number;
	}
	public int getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "order [order_id=" + order_id + ", member_id=" + member_id + ", order_created_date=" + order_created_date
				+ ", order_member_address=" + order_member_address + ", order_member_name=" + order_member_name
				+ ", order_member_phone=" + order_member_phone + ", order_status=" + order_status + ", point_used="
				+ point_used + ", order_sum_before=" + order_sum_before + ", order_sum_after=" + order_sum_after
				+ ", order_shipped_date=" + order_shipped_date + ", ship_number=" + ship_number + ", payment_status="
				+ payment_status + "]";
	}

}
