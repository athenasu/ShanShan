package tw.idv.tibame.tfa104.shanshan.web.member.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

//import java.sql.Blob;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
@Table(name = "member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Integer memberId;
	@Column(name = "member_name")
	private String memberName;
//	@ValidEmail
	@Column(name = "member_email", updatable = false)
	private String memberEmail;
	@Column(name = "member_password")
	private String memberPassword;
	@Column(name = "member_username")
	private String memberUsername;
	@Column(name = "member_phone_num")
	private String memberPhoneNum;
	@Column(name = "member_register_date")
	private Date memberRegisterDate;
	@Column(name = "member_profile_pic", columnDefinition = "LONGBLOB")
	private byte[] memberProfilePic;
	@Column(name = "member_intro", columnDefinition = "TEXT")
	private String memberIntro;
	@Column(name = "member_status")
	private Integer memberStatus;
	@Column(name = "member_sum_points")
	private Integer memberSumPoints;
	@Column(name = "member_subscription", columnDefinition = "int default 0")
	private Integer memberSubscription;
	@Transient
	private String picStr;
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
//	@OneToMany
//	private List<WishlistEvent> wishlistEvents;
//	@ManyToMany
//	@JoinTable(joinColumns = @JoinColumn(referencedColumnName = "member_id", name = "member_id"), name = "wishlist_product", inverseJoinColumns = @JoinColumn(referencedColumnName = "product_id", name = "product_id"))
//	private List<Product> wishlistProducts; // i used ManyToMany
//	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
//	@OneToMany
//	private List<WishlistArticle> wishlistArticle;
//
//	public List<Product> getWishlistProducts() {
//		return wishlistProducts;
//	}
//
//	public void setWishlistProducts(List<Product> wishlistProducts) {
//		this.wishlistProducts = wishlistProducts;
//	}
//
//	public List<WishlistArticle> getWishlistArticle() {
//		return wishlistArticle;
//	}
//
//	public void setWishlistArticle(List<WishlistArticle> wishlistArticle) {
//		this.wishlistArticle = wishlistArticle;
//	}
//
//	public List<WishlistEvent> getWishlistEvents() {
//		return wishlistEvents;
//	}
//
//	public void setWishlistEvents(List<WishlistEvent> wishlistEvents) {
//		this.wishlistEvents = wishlistEvents;
//	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberUsername() {
		return memberUsername;
	}

	public void setMemberUsername(String memberUsername) {
		this.memberUsername = memberUsername;
	}

	public String getMemberPhoneNum() {
		return memberPhoneNum;
	}

	public void setMemberPhoneNum(String memberPhoneNum) {
		this.memberPhoneNum = memberPhoneNum;
	}

	public Date getMemberRegisterDate() {
		return memberRegisterDate;
	}

	public void setMemberRegisterDate(Date memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}

	public byte[] getMemberProfilePic() {
		return memberProfilePic;
	}

	public void setMemberProfilePic(byte[] memberProfilePic) {
		this.memberProfilePic = memberProfilePic;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public Integer getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Integer getMemberSumPoints() {
		return memberSumPoints;
	}

	public void setMemberSumPoints(Integer memberSumPoints) {
		this.memberSumPoints = memberSumPoints;
	}

	public Integer getMemberSubscription() {
		return memberSubscription;
	}

	public void setMemberSubscription(Integer memberSubscription) {
		this.memberSubscription = memberSubscription;
	}

	public String getPicStr() {
		return picStr;
	}

	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}
	

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ ", memberPassword=" + memberPassword + ", memberUsername=" + memberUsername + ", memberPhoneNum="
				+ memberPhoneNum + ", memberRegisterDate=" + memberRegisterDate + ", memberProfilePic="
				+ Arrays.toString(memberProfilePic) + ", memberIntro=" + memberIntro + ", memberStatus=" + memberStatus
				+ ", memberSumPoints=" + memberSumPoints + ", memberSubscription=" + memberSubscription + ", picStr="
				+ picStr + "]";
	}
}
