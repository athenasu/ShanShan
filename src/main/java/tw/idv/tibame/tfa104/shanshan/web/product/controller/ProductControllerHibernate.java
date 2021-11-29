package tw.idv.tibame.tfa104.shanshan.web.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;

@RestController
@RequestMapping("product")//browser 要從product進來
public class ProductControllerHibernate {
	@Autowired
	private ProductServiceHibernate service;
	
	@GetMapping("findById")//跟productdes proimg重複
	public List<ProductBO> findById(Integer productId) {
		return service.findById(productId);
	}
	
	@GetMapping("findNew")
	public List<ProductBO> findNew(){
		return service.findNew();
	}
	
	@GetMapping("findByCompany")
	public List<ProductBO> findByCompanyName(String search){
		return service.findByCompanyName(search);
	}
	
	@GetMapping("findProdByName")
	public List<ProductBO> findProdNameByString(String search){
		return service.findProdNameByString(search);
	}
	
	@GetMapping("findByType")
	public List<ProductBO> findByType(Integer typeId){
		return service.findByType(typeId);
	}

	@GetMapping("findByComId")
	public List<ProductBO> findByCompanyId(Integer companyId){
		return service.findByCompanyId(companyId);
	}
	
	@GetMapping("getAll")
	public List<ProductBO> getAll(){
		return service.getAll();
	}
}
