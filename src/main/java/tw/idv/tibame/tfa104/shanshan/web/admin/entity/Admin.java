package tw.idv.tibame.tfa104.shanshan.web.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_info")
public class Admin {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer adminId;
	
	@Column(name = "admin_account")
	private String adminAccount;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_password")
	private String adminPassword;
	
	@Column(name = "admin_account_status")
	private Integer adminAccountStatus;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getAdminAccountStatus() {
		return adminAccountStatus;
	}

	public void setAdminAccountStatus(Integer adminAccountStatus) {
		this.adminAccountStatus = adminAccountStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminAccount=" + adminAccount + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", adminAccountStatus=" + adminAccountStatus + "]";
	}
	
	
}
