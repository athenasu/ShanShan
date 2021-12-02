package tw.idv.tibame.tfa104.shanshan.web.mountain.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;

public interface MountainDao {
	
	public Mountain findMtnByPk(Integer mtnId);
	public List<Mountain> findAllMtns();

}
