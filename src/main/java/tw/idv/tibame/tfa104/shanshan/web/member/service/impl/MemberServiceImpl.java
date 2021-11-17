package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAOHibernate memberDAOHibernate;

	@Override
	public int updateMemberPoints(Integer id, Integer points) {
		int result = memberDAOHibernate.updateMemberPoints(id, points);
		if (result == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	

	@Override
	public int deleteWishlistEvent(Integer id) {
		memberDAOHibernate.deleteWishlistEvent(id);
		return 1;
	}

	@Override
	public List<Member> findWishlistEvent(Integer id) {
		return memberDAOHibernate.findWishlistEvent(id);
	}

	@Override
	public Member findById(Integer id) {
		return memberDAOHibernate.selectById(id);
	}

	@Override
	public Member updateMember(byte[] file, Member member) {
		return memberDAOHibernate.update(file, member);
	}

	@Override
	public int registerMember(Member member) {
		System.out.println("in register service");
		// check if email has been registered already, send to the DAO and return an int
		boolean added = memberDAOHibernate.checkEmail(member.getMemberEmail());
		if (added) {
			System.out.println("This account already exists");
			return 0;
		}
		System.out.println("in register service: checked email");
		return memberDAOHibernate.register(member);
	}


}
