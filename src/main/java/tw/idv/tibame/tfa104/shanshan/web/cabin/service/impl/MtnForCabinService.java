package tw.idv.tibame.tfa104.shanshan.web.cabin.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.cabin.dao.MtnForCabinDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.cabin.dao.impl.MtnForCabinDAO;
import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;

public class MtnForCabinService {

	private MtnForCabinDAO_interface dao;
	
	public MtnForCabinService () {
		dao = new MtnForCabinDAO();
	}
	
	public List<Mountain> findByDistrict(Integer moutainDistrict) {
		return dao.findByDistrict(moutainDistrict);
	}

	public List<Event> eventByMtn(Integer mountain_id) {
		return dao.eventByMtn(mountain_id);
	}
	
	
}
