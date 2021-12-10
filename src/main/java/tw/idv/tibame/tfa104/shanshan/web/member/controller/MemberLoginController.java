package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.util.MailService;

@RestController
@RequestMapping("memberLogin")
public class MemberLoginController {
	
	@Autowired
	private MemberService service;
	
	@PostMapping("login")
	public Core login(@RequestBody Member member, HttpSession session) {
		Member loggedInMember = service.checkLogin(member);
		Core core = new Core();
		if (loggedInMember != null) {
			session.setAttribute("memberId", loggedInMember.getMemberId());
			session.setAttribute("memberName", loggedInMember.getMemberName());
			core.setSuccessful(true);
			core.setMessage("Login successful");
			return core;
		}
		core.setSuccessful(false);
		core.setMessage("Login unsuccessful");
		return core;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return "index";  // add our homepage here
	}
	
	@GetMapping("forgotPassword")
	public String forgotPassword(String email, HttpSession session, String token) {
		Jedis jedis = new Jedis("localhost", 6379);
		// check if there's a token
		System.out.println(token);
		if (token != null && token != "") {
			Integer memberId = Integer.parseInt(jedis.get(token));
			Member member = service.findById(memberId);
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			jedis.close();
//			System.out.println("has token");
			return "index"; // need to write a new forgot password jsp file
		}
		
		// check email first, use email to get memberId return Member
		Member member1 = service.checkEmail(email);
		System.out.println(member1);
		if (member1 != null) {
			MailService mailService = new MailService();
			String subject = "山山來此-忘記密碼";
			mailService.sendMail(email, subject, "memberLogin/forgotPassword", member1.getMemberId());
		}
//		System.out.println("no token");
		jedis.close();
		return "index"; // need to write a new forgot password jsp file
	}

}
