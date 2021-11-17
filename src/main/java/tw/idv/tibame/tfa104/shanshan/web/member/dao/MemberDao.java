package tw.idv.tibame.tfa104.shanshan.web.member.dao;

import tw.idv.tibame.tfa104.shanshan.core.dao.CoreDao;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;

public interface MemberDao extends CoreDao<Member, Integer> {
	
	Member selectByUsername(String username);
	
	Member selectForLogin(String username, String password);
}
