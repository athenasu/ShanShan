package tw.idv.tibame.tfa104.shanshan.web.core.controller;

import java.util.Enumeration;
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
	public Map<String, Object> checkSessionStatus (HttpSession session) {
		
//		session.setAttribute("memberId", 1);
//		session.setAttribute("memberName", "Athena");
		
		Map<String, Object> member = new HashMap<String, Object>();
		
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			member.put(name, value);
		}
		return member;
	}

}
