package tw.idv.tibame.tfa104.shanshan.web.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.dao.MemberDao;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao dao;

	@Override
	public int add(Member member) {
		return dao.insert(member);
	}

	@Override
	public int removeById(Integer id) {
		return dao.deleteById(id);
	}

	@Override
	public int modify(Member member) {
		return dao.update(member);
	}

	@Override
	public Member findById(Integer id) {
		return dao.selectById(id);
	}

	@Override
	public List<Member> findAll() {
		return dao.selectAll();
	}
}