package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;

public interface PointsUsedArticleService {
	
	public List<PointsUsedArticle> findPointsUsedArticles(Integer memberId);
	public List<Member> getMemberList(Integer articleId);
	public Integer pointsSpentArticle(PointsUsedArticle pointsUsedArticle);

}
