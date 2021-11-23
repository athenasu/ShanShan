package tw.idv.tibame.tfa104.shanshan.web.member.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.MemberWishlistArticle;

public interface MemberWishlistDao {

	public List<MemberWishlistArticle> findWishlistArticleByMemberId(Integer memberid);
	
	
}
