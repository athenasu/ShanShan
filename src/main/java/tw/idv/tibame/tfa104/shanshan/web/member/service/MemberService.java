package tw.idv.tibame.tfa104.shanshan.web.member.service;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberService {
	
	public Member findById(Integer id); // read
	public Integer registerMember(Member member); // create
	public Member updateMember(byte[] file, Member member); // update
	public Integer updateMemberPoints(Integer id, Integer points);
	public Integer findMemberPoints(Integer id);
	public Member checkLogin(Member member);
	public Member checkEmail(String email);
}

