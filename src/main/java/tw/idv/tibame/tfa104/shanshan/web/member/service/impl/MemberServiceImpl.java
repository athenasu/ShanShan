package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;
	
	@Override
	public Member checkEmail(String email) {
		return dao.checkEmail(email);
	}
	
	@Override
	public Member checkLogin(Member member) {
		Member loggedInMember = dao.checkLogin(member);
		if (loggedInMember != null) {
			return loggedInMember;
		} else {
			return null;
		}
	}
	

	@Override
	public Integer findMemberPoints(Integer id) {
		return dao.findMemberPoints(id);
	}

	@Override
	public Integer updateMemberPoints(Integer id, Integer points) {
		int result = dao.updateMemberPoints(id, points);
		if (result == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Member updateMember(byte[] file, Member member) {
		return dao.update(file, member);
	}

	@Override
	public Integer registerMember(Member member) {
		System.out.println("in register service");
		// check if email has been registered already, send to the DAO and return an int
		Member added = dao.checkEmail(member.getMemberEmail());
		if (added != null) {
			System.out.println("This account already exists");
			return 0;
		}
		System.out.println("in register service: checked email");
		return dao.register(member);
	}

	@Override
	public Member findById(Integer id) {
		Member member = dao.selectById(id);
		
		return member;
	}

}
