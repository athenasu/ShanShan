package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("findMemberById")
	public Member findMemberById(Integer memberId) { // change back to HttpSession session
//		Integer memberId = (Integer) session.getAttribute("memberId");
		final Member member = service.findById(memberId);
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
		System.out.println(result);
		return result;
	}
	
//	@GetMapping("test")
//	public Member test(HttpSession session) {
//		return (Member) session.getAttribute("member");
//	}
	
	@PostMapping("login")
//	public boolean login(@RequestBody Member member, final RedirectAttributes redirectAttributes) {
	public boolean login(@RequestBody Member member, HttpSession session) {
		Member loggedInMember = service.checkLogin(member);
		if (loggedInMember != null) {
			session.setAttribute("memberId", loggedInMember.getMemberId());
			return true;
		}
		return false;
	}
	
//	@PostMapping(path = "upload", consumes = { MediaType.APPLICATION_JSON_VALUE })
//	public Integer upload(@RequestBody Member member) {
//		// getting and decoding the file to Base64
//		byte[] file = Base64.getDecoder().decode(member.getPicStr());
//
//		try (FileOutputStream fos = new FileOutputStream("/Users/athenasu/Downloads/aaa.jpg");) {
//			fos.write(file);
//			fos.flush();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
}
