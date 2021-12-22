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
	public Member findMemberById(HttpSession session) { //HttpSession session
		Integer memberId = (Integer) session.getAttribute("memberId");
		final Member member = service.findById(memberId);
		member.setPicStr(Base64.getEncoder().encodeToString(member.getMemberProfilePic()));
		return member;
	}
	
	@GetMapping("findMemberByIdForEventMsg")
	public Member findMemberByIdForEventMsg(Integer memberId) {
		final Member member = service.findById(memberId);
		member.setPicStr(Base64.getEncoder().encodeToString(member.getMemberProfilePic()));
		return member;
	}

	@PostMapping("findMemberPoints")
	public Integer findMemberPoints(HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findMemberPoints(memberId);
	}

	@PostMapping("updateMemberPoints")
	public Integer updateMemberPoints(HttpSession session, Integer points) { 
		Integer memberId = (Integer)session.getAttribute("memberId");
		return service.updateMemberPoints(memberId, points);
	}

	@PostMapping(path = "memberUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Member memberUpdate(@RequestBody Member member, HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		member.setMemberId(memberId);
		byte[] file = Base64.getDecoder().decode(member.getPicStr());
		return service.updateMember(file, member);
	}

//	@GetMapping("test")
//	public Member test(HttpSession session) {
//		return (Member) session.getAttribute("member");
//	}

}
