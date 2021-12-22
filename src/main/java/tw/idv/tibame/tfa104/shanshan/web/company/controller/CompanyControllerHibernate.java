package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@RestController
@RequestMapping("company")
public class CompanyControllerHibernate {
	@Autowired
	private CompanyServiecHibernate service;
	
	@GetMapping("findByPK")
	public CompanyVO findByPK (Integer companyId) {
		CompanyVO company = service.findByPK(companyId);
//		company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
//		company.setPicStr2(Base64.getEncoder().encodeToString(company.getCompanyCetificate()));
		return company;
	}
	
	@GetMapping("findAllCompany")
	public List<CompanyVO> getAll(){
		return service.getAll();
	}
	
	@GetMapping("findComByString")
	public List<CompanyVO> findComByString(String search){
		return service.findComByString(search);
	}
	
	@PostMapping(path = "companyUpdate" , consumes = { MediaType.APPLICATION_JSON_VALUE})
	public CompanyVO companyUpdate(@RequestBody CompanyVO company) {
		byte[] file = Base64.getDecoder().decode(company.getPicStr());
		return service.update(file, company);
	}
	
	@PostMapping(path = "register" , consumes = { MediaType.APPLICATION_JSON_VALUE})
	public Integer register(@RequestBody CompanyVO company) {
		System.out.println(company.toString());
		int result = service.register(company);
		return result;
	}
	
	@PostMapping("updateStatus")
	public Core updateStatus(@RequestBody CompanyVO company,Core core) {
		System.out.println("in update companyStatus");
		Core core1 = service.updateStatus(company.getCompanyId(), company.getCompanyStatus(), core);
		return core1;
	}

	
	@PostMapping("login")
	public CompanyVO login(@RequestBody CompanyVO company, HttpSession session) {
		CompanyVO hadLogged = service.checkLogin(company);
		if(hadLogged != null) {
			System.out.println(hadLogged.getCompanyId());
			session.setAttribute("companyId", hadLogged.getCompanyId());
			return hadLogged;
		}else {
			return null;
		}
		
	}
	
	
}
