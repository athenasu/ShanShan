package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.service.PointsUsedArticleService;

@RestController
@RequestMapping("pointsUsedArticle")
public class PointsUsedArticleController {
	
	@Autowired
	private PointsUsedArticleService service;
	
	@GetMapping("findPointsUsedArticles")
	public List<PointsUsedArticle> findPointsUsedArticles(Integer memberId){ // change to session
		return service.findPointsUsedArticles(1);
	}
	
	@GetMapping("getMemberList")
	public List<Member> getMemberList(Integer articleId) {
		return service.getMemberList(articleId);
	}
	
	@PostMapping("pointsSpentArticle")
	public Integer pointsSpentArticle(@RequestBody PointsUsedArticle pointsUsedArticle) {
		return service.pointsSpentArticle(pointsUsedArticle);
	}

}
