package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.company.dao.CompanyDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;
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
		for (CompanyVO company : companyList) {
			company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
		}
		return companyList;
	}
	
	@Override
	public List<CompanyVO> findComByString(String search) {
		List<CompanyVO> companySearch = dao.findComByString(search);
		for(CompanyVO company : companySearch) {
			company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
		}
		return companySearch;
	}

	@Override
	public Integer register(CompanyVO company) {
		System.out.println("comapny register service");
		boolean added = dao.checkEmail(company.getCompanyEmail());
		if(added){
			System.out.println("This company already registered");
		}
		System.out.println("in service register check email");
		return 1;
	}

	@Override
	public CompanyVO update(byte[] file, CompanyVO company) {
		return dao.update(file,company);
	}


	
	

}
