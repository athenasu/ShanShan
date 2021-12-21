package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("redirect")
public class RedirectPageController {
	
	@RequestMapping("frontPage")
	public ModelAndView frontPage() {
		return new ModelAndView("index/index");
	}

}
