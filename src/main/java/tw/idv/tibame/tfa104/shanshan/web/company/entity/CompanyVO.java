package tw.idv.tibame.tfa104.shanshan.web.company.entity;

import java.io.Serializable;
import java.sql.Date;


public class CompanyVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer companyId;
	private String companyName;
	private String companyEmail;
	private String companyPassword;
	private String companyPhone;
	private String companyCell;
	private Date companyRegisterDate;
	private byte[] companyCetificate;
	private byte[] companyBanner;
	private String companyIntro;
	private String companyOwner;
	private String companyAddress;
	private Integer companyStatus;
	
	
	public CompanyVO(String companyName, String companyEmail , String companyPassword, String companyPhone, String companyCell, Date companyRegisterDate, String companyIntro, String companyOwner, String companyAddress ){
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyPassword = companyPassword;
		this.companyPhone = companyPhone;
		this.companyCell = companyCell;
		this.companyRegisterDate = companyRegisterDate;
		this.companyIntro = companyIntro;
		this.companyOwner = companyOwner;
		this.companyAddress = companyAddress;
		
	}
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
		
	
	
	

}
