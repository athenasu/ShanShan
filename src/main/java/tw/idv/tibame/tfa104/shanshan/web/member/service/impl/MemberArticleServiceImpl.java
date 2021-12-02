package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.event.dao.EventDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.MemberEventBO;
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
		return articleDao.findByMemIdGiveAll(memberId);
	}

	@Override
	public List<MemberEventBO> findEventByMemIdAndEventId(Integer memberId, Integer eventId) {
		return eventDao.selectByMemberId(memberId, eventId);
	}

	@Override
	public List<MemberEventBO> findAllEventsByMemId(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
