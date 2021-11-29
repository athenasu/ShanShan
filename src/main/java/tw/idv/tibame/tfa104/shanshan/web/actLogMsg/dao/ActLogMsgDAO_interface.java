package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.ActLogMsgVO;

public interface ActLogMsgDAO_interface {
	
	public void insertMsg(ActLogMsgVO ActLogMsgVO);
    public void update(ActLogMsgVO ActLogMsgVO);
    public void delete(Integer act_msg_id);
	public ActLogMsgVO findMsgByPK(Integer act_msg_id);
    public List<ActLogMsgVO> getAllMsg();
    
//    上架狀態留言
	public ActLogMsgVO findMsgByArtidStatus1(Integer article_id);

//	改變留言狀態
	public String changeMsgStatus(ActLogMsgVO ActLogMsgVO);

	
}
