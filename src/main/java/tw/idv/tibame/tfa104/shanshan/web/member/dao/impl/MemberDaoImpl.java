package tw.idv.tibame.tfa104.shanshan.web.member.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Member checkLogin(Member member) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);
		Predicate checkEmail = criteriaBuilder.equal(root.get("memberEmail"), member.getMemberEmail());
		Predicate checkPassword = criteriaBuilder.equal(root.get("memberPassword"), member.getMemberPassword());
		Predicate check = criteriaBuilder.and(checkEmail, checkPassword);
		criteriaQuery = criteriaQuery.where(check);
		Query<Member> query = session.createQuery(criteriaQuery);
		Member loggedInMember = query.uniqueResult();
		return loggedInMember;
	}
	
	
	@Override
	public Integer updateMemberPoints(Integer id, Integer points) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, id);
		int curPoints = member.getMemberSumPoints();
		int newPoints = curPoints + points;
		member.setMemberSumPoints(newPoints);
		return 1;
	}
	
	// find member by ID
	@Override
	public Member selectById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, id);
		return member;
	}

	@Override
	public Boolean checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<Member> query = session.createQuery("FROM Member WHERE memberEmail = :email", Member.class)
									 .setParameter("email", email);
		return query.uniqueResult() != null; // if it returns true, this means this account has already been registered
	}

	@Override
	public Integer register(Member member) {
		Session session = sessionFactory.getCurrentSession(); 
		File file = new File("/src/main/webapp/member/member_imgs/default_profile_pic.png");
		byte[] bFile= null; 
		try {
			FileInputStream fis = new FileInputStream(file);
			bFile = new byte[fis.available()];
			fis.read(bFile);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		member.setMemberProfilePic(bFile);
		
		System.out.println("committed");
		return (Integer) session.save(member);
	}

	@Override
	public Member update(byte[] file, Member member) {
		Session session = sessionFactory.getCurrentSession();

		Member tempMember = session.get(Member.class, 1); // just for testing, remember to change back!
		if (tempMember.getMemberName() != null && tempMember.getMemberName() != "") {
			tempMember.setMemberName(member.getMemberName());
		}
		
		if (tempMember.getMemberUsername() != null && tempMember.getMemberUsername() != "") {
			tempMember.setMemberUsername(member.getMemberUsername());
		}
		
		if (tempMember.getMemberPhoneNum() != null && tempMember.getMemberPhoneNum() != "") {
			tempMember.setMemberPhoneNum(member.getMemberPhoneNum());
		}
		
		if (tempMember.getMemberIntro() != null && tempMember.getMemberIntro() != "") {
			tempMember.setMemberIntro(member.getMemberIntro());
		}
		
		if (tempMember.getMemberProfilePic() != null) {
			tempMember.setMemberProfilePic(file);
		}
		
		return tempMember;
	}

	@Override
	public Integer findMemberPoints(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Member.class, id).getMemberSumPoints();
	}

}









