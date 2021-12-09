package tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.dao.PointsUsedArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.pointsUsedArticle.entity.PointsUsedArticle;
@Repository
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
//		where
//        member0_.member_id in (
//            2 , 3 , 4 , 5 , 6 , 7
//        )
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<PointsUsedArticle> criteriaQuery = criteriaBuilder.createQuery(PointsUsedArticle.class);
		Root<PointsUsedArticle> root = criteriaQuery.from(PointsUsedArticle.class);
		criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("articleId"), articleId));
		TypedQuery<PointsUsedArticle> typedQuery = session.createQuery(criteriaQuery);
		List<PointsUsedArticle> memberIds = typedQuery.getResultList();
		CriteriaQuery<Member> criteriaQueryMember = criteriaBuilder.createQuery(Member.class);
		Root<Member> rootMember = criteriaQueryMember.from(Member.class);
		Path<Object> path = rootMember.get("memberId"); // get memberId from rootMember
		CriteriaBuilder.In<Object> in = criteriaBuilder.in(path); // where memberId in()
		List<Integer> idList = new ArrayList<>();
		// add memberIds to idList
		for (int i = 0; i < memberIds.size(); i++) {
			idList.add(memberIds.get(i).getMemberId());
		}

		for (int i = 0; i < idList.size(); i++) {
			in.value(idList.get(i));
		}
		Predicate p1 = criteriaBuilder.and(criteriaBuilder.and(in));
		criteriaQueryMember = criteriaQueryMember.where(p1);
		TypedQuery<Member> typedQueryMember = session.createQuery(criteriaQueryMember);
		List<Member> members = typedQueryMember.getResultList();
		return members;
	}
	
	public Integer pointsSpentArticle(PointsUsedArticle pointsUsedArticle) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(pointsUsedArticle);
	}

}
