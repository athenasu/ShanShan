package tw.idv.tibame.tfa104.shanshan.web.member.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberWishlistDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.MemberWishlistArticle;

@Repository
public class MemberWishlistDaoImpl implements MemberWishlistDao {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public List<MemberWishlistArticle> findWishlistArticleByMemberId(Integer memberid) {
		Session session = sessionFactory.getCurrentSession();
//		 m.member_profile_pic, p.article_picture
		List<MemberWishlistArticle> wishlistArticles = session.createNativeQuery(
			"select " +
				"a.article_id as articleId, " + 
			    "a.article_title as articleTitle, " +
			    "a.event_date as eventDate, " +
//			    "ap.article_picture, " +
			    "m.member_name as memberName " +
//			    "m.member_profile_pic " +
			"from " +
				"article a " +
			    "join wishlist_article wa " +
					"on a.article_id = wa.article_id " +
			    "join article_picture ap " +
					"on a.article_id = ap.article_id " +
				"join member m " +
						"on a.member_id = m.member_id " +
			"where " +
				"ap.article_picture_id =( " +
				"select min(article_picture_id) " +
				"from article_picture " +
				"where article_id = ap.article_id " +
				"group by article_id) " +
				"and " +
				"wa.member_id = :id", MemberWishlistArticle.class)
				.setParameter("id", memberid)
//				.unwrap(MemberWishlistArticle.class)
				.list();
		return wishlistArticles;
	}
}
