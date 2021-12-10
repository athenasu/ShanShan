package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.util.MailService;

@RestController
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("findMemberById")
	public Member findMemberById(Integer memberId) { // change back to HttpSession session
//		Integer memberId = (Integer) session.getAttribute("memberId");
		final Member member = service.findById(1);
		member.setPicStr(Base64.getEncoder().encodeToString(member.getMemberProfilePic()));
		return member;
	}

	@PostMapping("findMemberPoints")
	public Integer findMemberPoints(Integer memberId) { // change back to HttpSession session
//		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findMemberPoints(memberId);
	}

	@PostMapping("updateMemberPoints")
	public Integer updateMemberPoints(Integer memberId, Integer points) { // change back to HttpSession session
//		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.updateMemberPoints(memberId, points);
	}

	@PostMapping(path = "memberUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Member memberUpdate(@RequestBody Member member) {
		byte[] file = Base64.getDecoder().decode(member.getPicStr());
		return service.updateMember(file, member);
	}

	@PostMapping(path = "register", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer register(@RequestBody Member member) {
		int result = service.registerMember(member);
		// send email
		MailService mailService = new MailService();
		String subject = "山山來此-會員註冊";
		String messageText = "歡迎加入山山來此！";
		mailService.sendMail(member.getMemberEmail(), subject, messageText);
		return result;
	}

	@PostMapping("login")
//	public boolean login(@RequestBody Member member, final RedirectAttributes redirectAttributes) {
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
	    return "redirect:/";  // add our homepage here
	}

//	@GetMapping("test")
//	public Member test(HttpSession session) {
//		return (Member) session.getAttribute("member");
//	}

}
