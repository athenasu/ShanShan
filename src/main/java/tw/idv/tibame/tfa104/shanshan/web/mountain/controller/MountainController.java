package tw.idv.tibame.tfa104.shanshan.web.mountain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;
import tw.idv.tibame.tfa104.shanshan.web.mountain.service.MountainService;

@RestController
@RequestMapping("mountain")
public class MountainController {

	@Autowired
	private MountainService service;

	@GetMapping("findMtnByPk")
	public Mountain findMtnByPk(Integer mtnId) {
		return service.findMtnByPk(mtnId);
	}

	@GetMapping("findAllMtns")
	public List<Mountain> findAllMtns() {
		return service.findAllMtns();
	}

}
