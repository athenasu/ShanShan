package tw.idv.tibame.tfa104.shanshan.web.member.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.save(member);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.load(Member.class, id);
		session.delete(member);
		return 1;
	}

	@Override
	public int update(Member member) {
		Session session = sessionFactory.getCurrentSession();
		session.update(member);
		return 1;
	}

	@Override
	public Member selectById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(Member.class, id);
	}

	@Override
	public List<Member> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Member", Member.class).list();
	}

	@Override
	public Member selectByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
		return session.createQuery(criteriaQuery)
				.uniqueResult();
	}
	
	@Override
	public Member selectForLogin(String username, String password) {
		final String sql = "select * from MEMBER "
				+ "where USERNAME = :username and PASSWORD = :password";
		Session session = sessionFactory.getCurrentSession();
		return (Member) session.createSQLQuery(sql)
			.addEntity(Member.class)
			.setParameter("username", username)
			.setParameter("password", password)
			.uniqueResult();
	}
}