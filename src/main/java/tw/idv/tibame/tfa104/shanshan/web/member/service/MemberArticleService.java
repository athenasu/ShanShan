package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;

public interface MemberArticleService {
	
	public List<ArticleVO> findAllArticlesByMemId (Integer memberId);
	// get MemberEventBO by selecting one specific event
	List<MemberEventBO> findEventByMemIdAndEventId(Integer memberId, Integer eventId);
	// get list of MemberEventBO by memberId
	List<MemberEventBO> findAllEventsByMemId(Integer memberId);

}
