package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Member registerMember(Member member) {
		Member existingMember = dao.checkEmail(member.getMemberEmail());
		if (existingMember != null) {
			return null; 
		} else {
			Member newMember = new Member();
			newMember.setMemberName(member.getMemberName());
			newMember.setMemberEmail(member.getMemberEmail());
			newMember.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
			int result = dao.register(newMember);
			System.out.println(result);
			System.out.println(newMember.getMemberPassword());
			return newMember;
		}
	}
	
	@Override
	public Member checkEmail(String email) {
		return dao.checkEmail(email);
	}
	
	@Override
	public Member checkLogin(Member member) {
//		Member loggedInMember = new Member();
//		loggedInMember.setMemberEmail(member.getMemberEmail());
//		loggedInMember.setMemberPassword(member.getMemberPassword()); 
//		Member checkedMember = dao.checkLogin(loggedInMember);
//		System.out.println(loggedInMember.getMemberPassword());
//		if (checkedMember != null) {
//			return checkedMember;
//		} else {
//			return null;
//		}
		// get the Member entity
		// get the encoded password
		// just checking if this member exists
		Member checkedMember = dao.checkEmail(member.getMemberEmail());
		boolean result = passwordEncoder.matches(member.getMemberPassword(), checkedMember.getMemberPassword());
		if (result) {
			return checkedMember;
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
		System.out.println("In service: " + member.toString());
		return dao.update(file, member);
	}

	@Override
	public Member findById(Integer id) {
		return dao.selectById(id);
	}
	
	@Override
	public Boolean updateMemberPassword(Integer memberId, String memberPassword) {
		Member result = dao.updateMemberPassword(memberId, passwordEncoder.encode(memberPassword));
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
