package tw.idv.tibame.tfa104.shanshan.web.member.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.wishlistEvent.entity.WishlistEvent;

@Repository // will tell Spring to make this a bean
public class MemberDaoImplHibernate implements MemberDAOHibernate {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int updateMemberPoints(Integer id, Integer points) {
		Session session = sessionFactory.getCurrentSession();
		Member member = session.get(Member.class, id);
		int curPoints = member.getMemberSumPoints();
		int newPoints = curPoints + points;
		member.setMemberSumPoints(newPoints);
		return 1;
	}
	
	@Override
	public int deleteWishlistEvent(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		WishlistEvent wishlist = session.get(WishlistEvent.class, id);
		session.delete(wishlist);
		return 1;
	}
	
	// just need one to get all the wishlists
	@Override
	public List<Member> findWishlistEvent (Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Member> query = session.createQuery("FROM Member WHERE member_id = :id", Member.class)
				.setParameter("id", id); 
		List<Member> members = query.list();
		return members;
	}
	
	@Override
	public Member selectById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Member.class, id);
	}

	@Override
	public boolean checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		// :email is like ?, Member.class is the return type
		Query<Member> query = session.createQuery("FROM Member WHERE memberEmail = :email", Member.class)
				.setParameter("email", email);
		return query.uniqueResult() != null; // if it returns true, this means this account has already been registered
	}

	@Override
	public int register(Member member) {
		Session session = sessionFactory.getCurrentSession(); 
		System.out.println("in dao register: adding picture");
		File file = new File("/src/defaultPictures/member/default_profile_pic.png");
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
		session.save(member);

		System.out.println("committed");
		// if information has successfully been added to the db, then it will return 1,
		return 1;
	}

	@Override
	public Member update(byte[] file, Member member) {
		Session session = sessionFactory.getCurrentSession();

		// i can get this from the member package that is thrown back i think
		Member tempMember = session.get(Member.class, 1); // just for testing
//		Member tempMember = session.get(Member.class, member.getMemberId());
		// probably need to move this stuff to the service layer
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
	public List<Member> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Member> query = session.createQuery("FROM Member", Member.class); // how do i get rid of this?
		List<Member> member = query.list();
		return member;
	}

}
