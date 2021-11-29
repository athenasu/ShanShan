package tw.idv.tibame.tfa104.shanshan.web.member.dao;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberDao {

	public Integer register(Member member); // create
	public Member selectById(Integer id); // read
	public Member update(byte[] file, Member member); // update
	public Boolean checkEmail(String email);
	public Integer updateMemberPoints(Integer id, Integer points);
	public Integer findMemberPoints(Integer id);
	public Member checkLogin(Member member) ;
}