package tw.idv.tibame.tfa104.shanshan.web.mountain.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;

public interface MountainService {
	
	public Mountain findMtnByPk(Integer mtnId);
	public List<Mountain> findAllMtns();

}
