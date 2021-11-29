package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao.ActLogMsgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.dao.impl.ActLogMsgDAO;
import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.ActLogMsgVO;

public class ActLogMsgService {
	
	private ActLogMsgDAO_interface dao;
	
	public ActLogMsgService(){
		dao = new ActLogMsgDAO();
	}

	public void insertMsg(ActLogMsgVO ActLogMsgVO) {
		
		dao.insertMsg(ActLogMsgVO);
	}

	public void update(ActLogMsgVO ActLogMsgVO) {
		dao.update(ActLogMsgVO);
	}

	public void delete(Integer act_msg_id) {
		dao.delete(act_msg_id);
	}

	public ActLogMsgVO findMsgByPK(Integer act_msg_id) {
		return dao.findMsgByPK(act_msg_id);
	}

	public List<ActLogMsgVO> getAllMsg() {
		return dao.getAllMsg();
	}

	public ActLogMsgVO findMsgByArtidStatus1(Integer article_id) {
		return dao.findMsgByArtidStatus1(article_id);
	}

	public String changeMsgStatus(ActLogMsgVO ActLogMsgVO) {
		return dao.changeMsgStatus(ActLogMsgVO);
	}
	
	

}
