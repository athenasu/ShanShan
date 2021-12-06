package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao.PointsUsedArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;

public class PointsUsedArticleDAOImpl implements PointsUsedArticleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PointsUsedArticle> findPointsUsedArticles(Integer memberId) {
//		SELECT * FROM points_used_act
//		WHERE member_id = 2;
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PointsUsedArticle> criteriaQuery = criteriaBuilder.createQuery(PointsUsedArticle.class);
		Root<PointsUsedArticle> root = criteriaQuery.from(PointsUsedArticle.class);
		criteriaQuery = criteriaQuery.where(
				criteriaBuilder.equal(root.get("memberId"), memberId)
				);
		TypedQuery<PointsUsedArticle> typedQuery = session.createQuery(criteriaQuery);
		List<PointsUsedArticle> pointsUsedArticles = typedQuery.getResultList();
		return pointsUsedArticles;
	}

	@Override
	public List<Member> getMemberList(Integer articleId) {
//		SELECT * FROM member m
//		JOIN points_used_act p ON m.member_id = p.member_id
//		WHERE p.article_id = 2025;
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		
		
		return null;
	}

}
