package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("redirect")
public class RedirectPageController {
	
	@RequestMapping("frontPage")
	public ModelAndView checkTokenForgotPassword() {
		return new ModelAndView("index/index");
	}

}
