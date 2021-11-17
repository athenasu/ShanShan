package tw.idv.tibame.tfa104.shanshan.web.member.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberDAOHibernate {

	public int register(Member member); // create
	public Member selectById(Integer id); // read
	public Member update(byte[] file, Member member); // update
	public boolean checkEmail(String email);
	public List<Member> selectAll();
	public List<Member> findWishlistEvent (Integer id);
	public int deleteWishlistEvent(Integer id);
	public int updateMemberPoints(Integer id, Integer points);
}