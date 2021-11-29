package tw.idv.tibame.tfa104.shanshan.web.productDescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.service.ProductDesService;


@RestController
@RequestMapping("product_description")
public class ProductDesController {
	@Autowired
	private ProductDesService service;
	
	@GetMapping("findByProductId")
	public List<FindByProductIdBO> findByProductId (Integer productId){
		return service.findByProductId(productId);
		
	}

	@GetMapping("findByPK")
	public List<FindByProductIdBO> findByPK (Integer prodesId){
		return service.findByPK(prodesId);
	}
	
	@GetMapping("findByStock")
	public List<FindByProductIdBO> findByStock (Integer prodesStock){
		return service.findByStock(prodesStock);
	}

	@GetMapping("getAll")
	public List<FindByProductIdBO> getAll(){
		return service.getAll();
	}
}
