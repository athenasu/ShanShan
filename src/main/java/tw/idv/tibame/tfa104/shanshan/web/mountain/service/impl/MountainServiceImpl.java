package tw.idv.tibame.tfa104.shanshan.web.mountain.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.idv.tibame.tfa104.shanshan.web.mountain.dao.MountainDao;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;
import tw.idv.tibame.tfa104.shanshan.web.mountain.service.MountainService;

@Service
@Transactional
public class MountainServiceImpl implements MountainService {
	
	@Autowired
	private MountainDao dao;

	@Override
	public Mountain findMtnByPk(Integer mtnId) {
		return dao.findMtnByPk(mtnId);
	}

	@Override
	public List<Mountain> findAllMtns() {
		return dao.findAllMtns();
	}

}
