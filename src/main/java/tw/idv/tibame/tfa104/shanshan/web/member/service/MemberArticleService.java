package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberArticleService {

	// articles that the member wrote
	public List<ArticleVO> findAllArticlesByMemId(Integer memberId);

	// get MemberEventBO by selecting one specific event
	List<MemberEventBO> findEventByMemIdAndEventId(Integer memberId, Integer eventId);

	// get list of MemberEventBO by memberId
	List<MemberEventBO> findAllEventsByMemId(Integer memberId);

	// get participating events by memberId
	public List<ParEventBO> findPartEventByMemberId(Integer memberId);
	
	// get list of participants from an event
	List<Member> parEventByEventId(Integer eventId);
	
}
