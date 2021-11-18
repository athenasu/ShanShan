package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.ActLogMsgVO;

public interface ActLogMsgDAO_interface {
	public void insert(ActLogMsgVO ActLogMsgVO);
//	public void update(ActLogMsgVO ActLogMsgVO);
	public void delete(Integer act_msg_id);
	public ActLogMsgVO findByPrimaryKey(Integer act_msg_id);
//    public List<ActLogMsgVO> getAll() ;
	

}
