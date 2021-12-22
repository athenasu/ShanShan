package tw.idv.tibame.tfa104.shanshan.web.company.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;

public interface CompanyDAOHibernate {
	
	public Integer register(CompanyVO company);
	public CompanyVO update(byte[]file,CompanyVO company);
	//更新店家狀態
	public Integer updateStatus(Integer companyId,Integer companyStatus);
	public CompanyVO checkEmail(String email);
	public CompanyVO checkLogin(CompanyVO company);
	public CompanyVO findByPK(Integer companyId);//得到完整單一店家資料
	List <CompanyVO> getAll();//得到所有店家資訊
	List <CompanyVO> findComByString(String search);//模糊查詢店家資訊
	
	
	
	
	
	

}
