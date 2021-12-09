package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao.PointsUsedArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.service.PointsUsedArticleService;

@Service
@Transactional
public class PointsUsedArticleServiceImpl implements PointsUsedArticleService {
	
	@Autowired
	private PointsUsedArticleDAO dao;

	@Override
	public List<PointsUsedArticle> findPointsUsedArticles(Integer memberId) {
		return dao.findPointsUsedArticles(memberId);
	}

	@Override
	public List<Member> getMemberList(Integer articleId) {
		return dao.getMemberList(articleId);
	}
	
	@Override
	public Integer pointsSpentArticle(PointsUsedArticle pointsUsedArticle) {
		return dao.pointsSpentArticle(pointsUsedArticle);
	}
	
}
