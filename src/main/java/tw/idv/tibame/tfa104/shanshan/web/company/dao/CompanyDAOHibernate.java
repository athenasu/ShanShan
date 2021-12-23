package tw.idv.tibame.tfa104.shanshan.web.company.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;

public interface CompanyDAOHibernate {
	
	//店家註冊
	public Integer register(CompanyVO company);
	//店家資料維護
	public CompanyVO update(byte[]file,CompanyVO company);
	//更新店家狀態
	public Integer updateStatus(Integer companyId,Integer companyStatus);
	//登入email確認
	public CompanyVO checkEmail(String email);
	//登入店家狀態確認(1：審核通過才可登入)
	//登入確認
	public CompanyVO checkLogin(CompanyVO company);
	//得到完整單一店家資料
	public CompanyVO findByPK(Integer companyId);
	//得到所有店家資訊
	List <CompanyVO> getAll();
	//模糊查詢店家資訊
	List <CompanyVO> findComByString(String search);
	
	
	
	
	
	

}
