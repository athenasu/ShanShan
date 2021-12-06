package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;

@RestController
@RequestMapping("company")
public class CompanyControllerHibernate {
	@Autowired
	private CompanyServiecHibernate service;
	
	@GetMapping("findByPK")
	public CompanyVO findByPK () {
		CompanyVO company = service.findByPK(1);
		company.setPicStr(Base64.getEncoder().encodeToString(company.getCompanyBanner()));
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
	
	@PostMapping(path = "companyUpdate" , consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompanyVO companyUpdate(@RequestBody CompanyVO company) {
		byte[] file = Base64.getDecoder().decode(company.getPicStr());
		return service.update(file, company);
	}
	@PostMapping(path = "register" , consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Integer register(@RequestBody CompanyVO company) {
		System.out.println("in controller ");
		int result = service.register(company);
		return result;
	}
}
