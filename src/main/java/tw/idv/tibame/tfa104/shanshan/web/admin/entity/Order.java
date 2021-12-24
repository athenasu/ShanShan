package tw.idv.tibame.tfa104.shanshan.web.admin.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "company_id")
	private Integer companyId;
	
	@Column(name = "order_created_date")
	private Date orderCreatedDate;
	
	@Column(name = "order_member_address")
	private String orderMemberAddress;
	
	@Column(name = "order_member_name")
	private String orderMemberName;
	
	@Column(name = "order_member_phone")
	private String orderMemberPhone;
	
	@Column(name = "order_status")
	private Integer orderStatus;
	
	@Column(name = "point_used")
	private Integer pointUsed;
	
	@Column(name = "order_sum_before")
	private Integer orderSumBefore;

	@Column(name = "order_sum_after")
	private Integer orderSumAfter;

	@Column(name = "order_shipped_date")
	private Date orderShippedDate;

	@Column(name = "ship_number")
	private String shipNumber;
	
	@Column(name = "payment_status")
	private Integer paymentStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Date getOrderCreatedDate() {
		return orderCreatedDate;
	}

	public void setOrderCreatedDate(Date orderCreatedDate) {
		this.orderCreatedDate = orderCreatedDate;
	}

	public String getOrderMemberAddress() {
		return orderMemberAddress;
	}

	public void setOrderMemberAddress(String orderMemberAddress) {
		this.orderMemberAddress = orderMemberAddress;
	}

	public String getOrderMemberName() {
		return orderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}

	public String getOrderMemberPhone() {
		return orderMemberPhone;
	}

	public void setOrderMemberPhone(String orderMemberPhone) {
		this.orderMemberPhone = orderMemberPhone;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getPointUsed() {
		return pointUsed;
	}

	public void setPointUsed(Integer pointUsed) {
		this.pointUsed = pointUsed;
	}

	public Integer getOrderSumBefore() {
		return orderSumBefore;
	}

	public void setOrderSumBefore(Integer orderSumBefore) {
		this.orderSumBefore = orderSumBefore;
	}

	public Integer getOrderSumAfter() {
		return orderSumAfter;
	}

	public void setOrderSumAfter(Integer orderSumAfter) {
		this.orderSumAfter = orderSumAfter;
	}

	public Date getOrderShippedDate() {
		return orderShippedDate;
	}

	public void setOrderShippedDate(Date orderShippedDate) {
		this.orderShippedDate = orderShippedDate;
	}

	public String getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(String shipNumber) {
		this.shipNumber = shipNumber;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", memberId=" + memberId + ", companyId=" + companyId
				+ ", orderCreatedDate=" + orderCreatedDate + ", orderMemberAddress=" + orderMemberAddress
				+ ", orderMemberName=" + orderMemberName + ", orderMemberPhone=" + orderMemberPhone + ", orderStatus="
				+ orderStatus + ", pointUsed=" + pointUsed + ", orderSumBefore=" + orderSumBefore + ", orderSumAfter="
				+ orderSumAfter + ", orderShippedDate=" + orderShippedDate + ", shipNumber=" + shipNumber
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	
	
}
