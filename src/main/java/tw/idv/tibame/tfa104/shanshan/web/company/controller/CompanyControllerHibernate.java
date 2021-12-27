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
import org.springframework.web.servlet.view.RedirectView;

import redis.clients.jedis.Jedis;
import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.util.MailService;

@RestController
@RequestMapping("company")
public class CompanyControllerHibernate {
	@Autowired
	private CompanyServiecHibernate service;
	
	@GetMapping("findByPK")
	public CompanyVO findByPK (HttpSession session) {
		Integer companyId = (Integer)session.getAttribute("companyId");
		CompanyVO company = service.findByPK(companyId);
		return company;
	}
	//for Owen use
	@GetMapping("findByComId")
	public CompanyVO findByComId(Integer companyId) {
		return service.findByPK(companyId);
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
	public CompanyVO companyUpdate(@RequestBody CompanyVO company,HttpSession session) {
		Integer companyId = (Integer)session.getAttribute("companyId");
		company.setCompanyId(companyId);
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
		CompanyVO checkStatus = service.checkStatus(company);
		//要再加一個確認店家狀態
		if(hadLogged != null && checkStatus != null) {
			System.out.println(hadLogged.getCompanyId());
			session.setAttribute("companyId", hadLogged.getCompanyId());
			return hadLogged;
		}else {
			return null;
		}
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "logout";
	}
	
	@PostMapping("forgetPwdCheckEmail")
	public Core forgetPwdCheckEmail(@RequestBody CompanyVO company) {
		Core core = new Core();
		CompanyVO company1 = service.checkEmail(company.getCompanyEmail());
		if(company1 != null) {
			MailService mailservice = new MailService();
			String subject = "山山來此-忘記密碼";
			boolean mailSent = mailservice.sendMail(company.getCompanyEmail(),subject, "company/checkTokenForgetPwd", company1.getCompanyId());
			if(mailSent && company1 != null) {
				core.setSuccessful(true);
			}else {
				core.setSuccessful(false);
			}
		}
		return core;
	}
	
	@GetMapping("checkTokenForgetPwd")
	public RedirectView checkTokenForgetPwd(String token,HttpSession session) {
		Jedis jedis = new Jedis("localhost", 6379);
		if(token != null && token != "") {
			Integer companyId = Integer.parseInt(jedis.get(token));
			CompanyVO company = service.findByPK(companyId);
			session.setAttribute("companyId", company.getCompanyId());
			jedis.close();
		}
		jedis.close();
		return new RedirectView("../company/company_changePwd.html");
	}
	
	@PostMapping("changePwd")
	public RedirectView changePwd(@RequestBody CompanyVO company, HttpSession session) {
		int companyId = (Integer) session.getAttribute("companyId");
		service.updateCompanyPwd(companyId, company.getCompanyPassword());
		return new RedirectView("../company/company_login.html");
	}
	
}
