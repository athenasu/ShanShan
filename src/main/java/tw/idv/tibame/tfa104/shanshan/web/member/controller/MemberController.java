package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.io.FileOutputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;

@RestController // using Spring RESTful to use this controller, which means it will get JSON information
@RequestMapping("member")
@SessionAttributes({ "member" })
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("findMemberById")
	public Member findMemberById() { // need to change it back to using an Integer
		  final Member member = service.findById(1);
		  member.setPicStr(Base64.getEncoder().encodeToString(member.getMemberProfilePic()));
		return member;
	}
	
	@PostMapping("findMemberPoints")
	public int findMemberPoints(Integer id) {
		return service.findMemberPoints(id);
	}
	
	@PostMapping("updateMemberPoints")
	public int updateMemberPoints(Integer id, Integer points) {
		return service.updateMemberPoints(id, points);
	}
	
	@PostMapping(path = "memberUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Member memberUpdate(@RequestBody Member member) {
		byte[] file = Base64.getDecoder().decode(member.getPicStr());
		return service.updateMember(file, member);
	}

	@PostMapping(path = "register", consumes = { MediaType.APPLICATION_JSON_VALUE }) // tells the front end that we're sending a JSON file																						// sending a JSON type
	public int register(@RequestBody Member member) {
		System.out.println("in controller");
		int result = service.registerMember(member);
		System.out.println(result);
		return result;
	}

	@PostMapping(path = "upload", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public int upload(@RequestBody Member member) {
		// getting and decoding the file to Base64
		byte[] file = Base64.getDecoder().decode(member.getPicStr());

		try (FileOutputStream fos = new FileOutputStream("/Users/athenasu/Downloads/aaa.jpg");) {
			fos.write(file);
			fos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@GetMapping("login")
	public void login(Model model, Member member) {
		// will need to add this method, as soon as i set the user's email and password,
		// i'll be able to set their information in the session
		// and everyone else will be able to get it
//		member = service.findByUsernameAndPassword(member);
		member.setMemberId(123);
		member.setMemberUsername("william");
		model.addAttribute("member", member);
	}
}
