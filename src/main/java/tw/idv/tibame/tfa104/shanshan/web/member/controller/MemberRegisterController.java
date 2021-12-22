package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.util.MailService;

@RestController
@RequestMapping("memberRegister")
public class MemberRegisterController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping(path = "register", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Core register(@RequestBody Member member, Core core) {
		Member addedMember = service.registerMember(member); 
		// send email
		if (addedMember == null) {
			core.setSuccessful(false);
			core.setMessage("Member already exists");
			return core;
		}
		MailService mailService = new MailService();
		String subject = "山山來此-會員註冊";
		boolean mailSent = mailService.sendMail(addedMember.getMemberEmail(), subject, "memberRegister/authenicate", addedMember.getMemberId());
		
		if (mailSent && addedMember != null) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}
	
	@PostMapping(path = "fbRegister", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Core fbRegister(@RequestBody Member member, Core core) {
		Member addedMember = service.fbRegisterMember(member); 
		// send email
		if (addedMember == null) {
			core.setSuccessful(false);
			core.setMessage("Member already exists");
			return core;
		}
		MailService mailService = new MailService();
		String subject = "山山來此-會員註冊";
		boolean mailSent = mailService.sendMail(addedMember.getMemberEmail(), subject, "memberRegister/authenicate", addedMember.getMemberId());
		
		if (mailSent && addedMember != null) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}
	
	@GetMapping("authenicate")  
	public ModelAndView authenticate(String token, HttpSession session) {
		Jedis jedis = new Jedis("localhost", 6379);
		try {
			// checking token if it matches with the token in Jedis
			Integer memberId = Integer.parseInt(jedis.get(token));
			Member member = service.findById(memberId);
			// setting session
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			System.out.println(member.getMemberName());
			System.out.println(member.getMemberId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jedis.close();
		return new ModelAndView("index/index"); 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
	StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
	dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
}
