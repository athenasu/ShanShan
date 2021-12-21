package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberArticleService;

@RestController
@RequestMapping("memberArticle")
public class MemberArticleController {
	
	@Autowired
	private MemberArticleService service;
	
	@GetMapping("findAllArticlesByMemId")
	public List<ArticleVO> findAllArticlesByMemId (HttpSession session){ //HttpSession session
		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findAllArticlesByMemId(memberId);
	}

	@GetMapping("findAllEventsByMemId")
	public List<MemberEventBO> findAllEventsByMemId(HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findAllEventsByMemId(memberId);
	}
	
	@GetMapping("findEventByMemIdAndEventId")
	public List<MemberEventBO> findEventByMemIdAndEventId(HttpSession session, Integer eventId) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findEventByMemIdAndEventId(memberId, eventId);
	}
	
	@GetMapping("findPartEventByMemberId")
	public List<ParEventBO> findPartEventByMemberId(HttpSession session) {
		Integer memberId = (Integer) session.getAttribute("memberId");
		return service.findPartEventByMemberId(memberId);
	}
	
	@GetMapping("findParEventByEventId")
	public List<Member> findParEventByEventId(Integer eventId) {
		return service.parEventByEventId(eventId);
	}


	
}
