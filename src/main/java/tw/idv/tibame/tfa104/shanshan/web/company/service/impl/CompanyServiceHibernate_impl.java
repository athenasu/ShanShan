package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.company.dao.CompanyDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
@Service
@Transactional
public class CompanyServiceHibernate_impl implements CompanyServiecHibernate {
	@Autowired
	private CompanyDAOHibernate dao;
	
	
	@Override
	public CompanyVO findByPK(Integer companyId) {
		return dao.findByPK(companyId);
	}
	
	@Override
	public List<CompanyVO> getAll() {
		List<CompanyVO> companyList = dao.getAll(); 
//		for (CompanyVO company : companyList) {
//			company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
//		}
		return companyList;
	}
	
	@Override
	public List<CompanyVO> findComByString(String search) {
		List<CompanyVO> companySearch = dao.findComByString(search);
//		for(CompanyVO company : companySearch) {
//			company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
//		}
		return companySearch;
	}

	@Override
	public Integer register(CompanyVO company) {
		CompanyVO existed = dao.checkEmail(company.getCompanyEmail());
		if(existed != null) {
			System.out.println("this company had registered");
			return 0;
		}
//		byte[] bytefile2 = Base64.getDecoder().decode(company.getPicStr2());
//		company.setCompanyCetificate(bytefile2);
		return dao.register(company);
	}

	@Override
	public CompanyVO checkEmail(String email) {
		return dao.checkEmail(email);
	}

	@Override
	public CompanyVO update(byte[] file, CompanyVO company) {
		return dao.update(file, company);
	}

	@Override
	public CompanyVO checkLogin(CompanyVO company) {
		CompanyVO hadLogged = dao.checkLogin(company);
		if(hadLogged != null) {
			return hadLogged;
		}else {
			return null;
		}
		
	}

	@Override
	public Core updateStatus(Integer companyId, Integer companyStatus, Core core) {
		int result = dao.updateStatus(companyId, companyStatus);
		if (result == 1) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setSuccessful(false);
			return core;
		}
	}



	

	


	
	

}
