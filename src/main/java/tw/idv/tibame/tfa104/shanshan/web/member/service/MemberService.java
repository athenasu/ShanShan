package tw.idv.tibame.tfa104.shanshan.web.member.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberService {
	
	public Member findById(Integer id); // read
	public int registerMember(Member member); // create
	public Member updateMember(byte[] file, Member member); // update
	public List<Member> findWishlistEvent (Integer id);
	public int deleteWishlistEvent(Integer id);
	public int updateMemberPoints(Integer id, Integer points);
	
}