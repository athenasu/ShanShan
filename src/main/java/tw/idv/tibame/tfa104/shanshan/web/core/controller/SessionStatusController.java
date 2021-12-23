package tw.idv.tibame.tfa104.shanshan.web.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessionStatus")
public class SessionStatusController {

	@GetMapping("checkSessionStatus")
	public Map<String, Object> checkSessionStatus(HttpSession session) {

		Map<String, Object> member = new HashMap<String, Object>();

		String memberName = (String) session.getAttribute("memberName");
		Integer memberId = (Integer) session.getAttribute("memberId");
		member.put("memberName", memberName);
		member.put("memberId", memberId);
		return member;
	}

}
