package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberWishlistDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.MemberWishlistArticle;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberWishlistService;

@Service
@Transactional
public class MemberWishlistServiceImpl implements MemberWishlistService {
	
	@Autowired
	private MemberWishlistDao dao;
	
	@Override
	public  List<MemberWishlistArticle> findWishlistArticleByMemberId(Integer memberid) {
		// need to only send back one picture
		List<MemberWishlistArticle> object = dao.findWishlistArticleByMemberId(memberid);
		return object;
	}

}
