package tw.idv.tibame.tfa104.shanshan.web.member.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberDAO {

	public int register(Member member); // create
	public Member selectById(Integer id); // read
	public Member update(byte[] file, Member member); // update
	public boolean checkEmail(String email);
	public List<Member> selectAll();
	public List<Member> findAllWishlists (Integer id);
	public List<Event> findWishlistEventsByMemberId (Integer id);
	public int deleteWishlistEvent(Integer id);
	public int updateMemberPoints(Integer id, Integer points);
	public int findMemberPoints(Integer id);
}