package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("redirect")
public class RedirectPageController {
	
	@RequestMapping("frontPage")
	public RedirectView frontPage() {
		return new RedirectView("../index/index.jsp");
	}

}
