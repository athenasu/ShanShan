package tw.idv.tibame.tfa104.shanshan.web.company.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import org.hibernate.annotations.DynamicInsert;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@DynamicInsert
@Table(name = "company")
public class CompanyVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Integer companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "company_email")
	private String companyEmail;
	
	@Column(name = "company_password")
	private String companyPassword;
	
	@Column(name = "company_phone")
	private String companyPhone;
	
	@Column(name = "company_cell")
	private String companyCell;
	
	@Column(name = "company_register_date")
	private Date companyRegisterDate;
	
	@Column(name = "company_cetificate")
	private byte[] companyCetificate;
	
	@Column(name = "company_banner")
	private byte[] companyBanner;
	
	@Column(name = "company_intro")
	private String companyIntro;
	
	@Column(name = "company_owner")
	private String companyOwner;
	
	@Column(name = "company_address")
	private String companyAddress;
	
	@Column(name = "company_status")
	private Integer companyStatus;
	
	@Transient
	private String picStr;
	
	public CompanyVO() {
		super();
	}
	
	
	public Integer getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	
	
	public String getCompanyPassword() {
		return companyPassword;
	}
	
	
	public void setCompanyPassword(String companyPassword) {
		this.companyPassword = companyPassword;
	}
	
	
	public String getCompanyPhone() {
		return companyPhone;
	}
	
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	
	
	public String getCompanyCell() {
		return companyCell;
	}
	
	public void setCompanyCell(String companyCell) {
		this.companyCell = companyCell;
	}
	
	
	public Date getCompanyRegisterDate() {
		return companyRegisterDate;
	}
	
	public void setCompanyRegisterDate(Date companyRegisterDate) {
		this.companyRegisterDate = companyRegisterDate;
	}
	
	
	public byte[] getCompanyCetificate() {
		return companyCetificate;
	}
	
	public void setCompanyCetificate(byte[] companyCetificate) {
		this.companyCetificate = companyCetificate;
	}

	
	public byte[] getCompanyBanner() {
		return companyBanner;
	}
	
	public void setCompanyBanner(byte[] companyBanner) {
		this.companyBanner = companyBanner;
	}
	
	
	public String getCompanyIntro() {
		return companyIntro;
	}
	
	public void setCompanyIntro(String companyIntro) {
		this.companyIntro = companyIntro;
	}
	
	
	public String getCompanyOwner() {
		return companyOwner;
	}
	
	public void setCompanyOwner(String companyOwner) {
		this.companyOwner = companyOwner;
	}
	
	
	public String getCompanyAddress() {
		return companyAddress;
	}
	
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	public Integer getCompanyStatus() {
		return companyStatus;
	}
	
	public void setCompanyStatus(Integer companyStatus) {
		this.companyStatus = companyStatus;
	}
		
	public String getPicStr() {
		return picStr;
	}

	public void setPicStr(String picStr) {
		this.picStr = picStr;
	}

//	@Override
//	public String toString() {
//		return "CompanyVO [companyId=" + companyId + ", companyName=" + companyName + ", companyEmail=" + companyEmail
//				+ ", companyPassword=" + companyPassword + ", companyPhone=" + companyPhone + ", companyCell="
//				+ companyCell + ", companyRegisterDate=" + companyRegisterDate + ", companyCetificate="
//				+ Arrays.toString(companyCetificate) + ", companyBanner=" + Arrays.toString(companyBanner)
//				+ ", companyIntro=" + companyIntro + ", companyOwner=" + companyOwner + ", companyAddress="
//				+ companyAddress + ", companyStatus=" + companyStatus + ", picStr=" + picStr
//				+ "]";
//	}
	
	

}
