package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.core.service.CoreService;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberService extends CoreService {

	int add(Member member);

	int removeById(Integer id);

	int modify(Member member);

	Member findById(Integer id);

	List<Member> findAll();
}