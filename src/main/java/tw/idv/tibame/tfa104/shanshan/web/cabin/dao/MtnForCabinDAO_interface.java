package tw.idv.tibame.tfa104.shanshan.web.cabin.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;

public interface MtnForCabinDAO_interface {
	
	public List<Mountain> findByDistrict(Integer moutainDistrict);
	public List<Event> eventByMtn(Integer mountain_id);

}
