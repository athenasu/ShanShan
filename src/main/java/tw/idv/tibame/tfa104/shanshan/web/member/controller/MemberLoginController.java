package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

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
//			System.out.println(loggedInMember.getMemberName());
//			System.out.println(loggedInMember.getMemberId());
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
	
	@PostMapping("facebookLogin")
	public Core facebookLogin(@RequestBody Member member, HttpSession session) {
		Core core = new Core();
		Member existingMember = service.checkEmail(member.getMemberEmail());
		if (existingMember != null) {
			System.out.println(existingMember.getMemberName());
			System.out.println(existingMember.getMemberId());
			session.setAttribute("memberId", existingMember.getMemberId());
			session.setAttribute("memberName", existingMember.getMemberName());
			core.setSuccessful(true);
			core.setMessage("Login successful");
		} else {
			core.setSuccessful(false);
			core.setMessage("Email does not exist");
		}
		return core;
	}

	@RequestMapping("logout")
	public RedirectView logout(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
		return new RedirectView("../index/index.jsp");
	}

	@PostMapping("forgotPasswordCheckEmail")
	public Core forgotPasswordCheckEmail(@RequestBody Member member) {
		// check email first, use email to get memberId return Member
		Core core = new Core();
		Member member1 = service.checkEmail(member.getMemberEmail());
		if (member1 != null) {
			MailService mailService = new MailService();
			String subject = "山山來此-忘記密碼";
			boolean mailSent = mailService.sendMail(member.getMemberEmail(), subject, "memberLogin/checkTokenForgotPassword", member1.getMemberId());
			if (mailSent && member1 != null) {
				core.setSuccessful(true);
			} else {
				core.setSuccessful(false);
			}
		}
		return core;
	}

	@GetMapping("checkTokenForgotPassword")
	public RedirectView checkTokenForgotPassword(String token, HttpSession session) {
		Jedis jedis = new Jedis("localhost", 6379);
		if (token != null && token != "") {
			Integer memberId = Integer.parseInt(jedis.get(token));
			Member member = service.findById(memberId);
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			jedis.close();
		} 
		jedis.close();
		return new RedirectView("../member/change_password.html"); // jsp or html page--> need to test this
	}
	
	@PostMapping("changePassword")
	public RedirectView changePassword(@RequestBody Member member, HttpSession session) {
		int memberId = (Integer) session.getAttribute("memberId");
		service.updateMemberPassword(memberId, member.getMemberPassword());
		return new RedirectView("../index/index.jsp");
	}
}
