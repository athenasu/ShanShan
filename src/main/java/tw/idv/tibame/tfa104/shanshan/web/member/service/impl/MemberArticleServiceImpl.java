package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.ParEventBO;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberArticleService;

@Service
@Transactional
public class MemberArticleServiceImpl implements MemberArticleService {
	
	@Autowired
	private ArticleDAO_interface articleDao;
	
	@Autowired
	private EventDAO eventDao;

	@Override
	public List<ArticleVO> findAllArticlesByMemId(Integer memberId) {
		List<ArticleVO> articles = articleDao.findByMemIdGiveAll(memberId);
		for (ArticleVO article : articles) {			
			article.setPicString(Base64.getEncoder().encodeToString(article.getArticle_picture()));
		}
		return articles;
	}

	@Override
	public List<MemberEventBO> findAllEventsByMemId(Integer memberId) {
		return eventDao.selectByMemberId(memberId);
	}

	@Override
	public List<MemberEventBO> findEventByMemIdAndEventId(Integer memberId, Integer eventId) {
		return eventDao.selectByMemberId(memberId, eventId);
	}

	@Override
	public List<ParEventBO> findPartEventByMemberId(Integer memberId) {
		List<ParEventBO> participants = eventDao.parEventByMember(memberId);
		for (ParEventBO participant : participants) {			
			participant.setPicString(Base64.getEncoder().encodeToString(participant.getMountainPic()));
		}
		return participants;
	}
	
	@Override
	public List<Member> parEventByEventId(Integer eventId) {
		List<Member> participants = eventDao.parEventByEventId(eventId);
		for (Member participant : participants) {
			participant.setPicStr(Base64.getEncoder().encodeToString(participant.getMemberProfilePic()));
		}
		return participants;
	}
	
	@Override
	public Integer cancelEvent(Integer eventId) {
		return eventDao.deleteEventById(eventId);
	}
	
}
