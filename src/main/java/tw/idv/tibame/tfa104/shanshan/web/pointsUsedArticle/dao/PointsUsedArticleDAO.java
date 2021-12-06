package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;

public interface PointsUsedArticleDAO {
	
	public List<PointsUsedArticle> findPointsUsedArticles(Integer memberId);
	public List<Member> getMemberList(Integer articleId);

}
