package tw.idv.tibame.tfa104.shanshan.web.company.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;

public interface CompanyServiecHibernate {
	
	public Integer register(CompanyVO company);
	public CompanyVO checkEmail(String email);
	public CompanyVO checkLogin(CompanyVO company);
	//取得店家狀態確認(1：審核通過才可登入)
	public Core getStatus(String email,Core core);
	public CompanyVO update(byte[]file,CompanyVO company);
	public Core updateStatus(Integer companyId,Integer companyStatus,Core core);
	public Boolean updateCompanyPwd(Integer companyId, String companyPassword);
	public CompanyVO findByPK(Integer companyId);
	List <CompanyVO> getAll();
	List <CompanyVO> findComByString(String search);
}