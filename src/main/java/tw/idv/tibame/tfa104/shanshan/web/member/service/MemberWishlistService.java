package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.MemberWishlistArticle;

public interface MemberWishlistService {
	
	public  List<MemberWishlistArticle> findWishlistArticleByMemberId (Integer memberid);

}
