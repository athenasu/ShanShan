package tw.idv.tibame.tfa104.shanshan.web.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberArticleService;

@RestController
@RequestMapping("memberArticle")
public class MemberArticleController {
	
	@Autowired
	private MemberArticleService service;
	
	@GetMapping("findAllArticlesByMemId")
	public List<ArticleVO> findAllArticlesByMemId (Integer memberId){
		return service.findAllArticlesByMemId(memberId);
	}

	@GetMapping("findAllEventsByMemId")
	public List<MemberEventBO> findAllEventsByMemId(Integer memberId) {
		return service.findAllEventsByMemId(memberId);
	}
	
	@GetMapping("findEventByMemIdAndEventId")
	public List<MemberEventBO> findEventByMemIdAndEventId(Integer memberId, Integer eventId) {
		return service.findEventByMemIdAndEventId(memberId, eventId);
	}
	
}