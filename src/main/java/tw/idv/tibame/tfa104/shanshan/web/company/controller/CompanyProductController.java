package tw.idv.tibame.tfa104.shanshan.web.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyProductService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

@RestController
@RequestMapping("companyProduct")
public class CompanyProductController {
	
	@Autowired
	private CompanyProductService service;
	
	//新增商品
//	@PostMapping(path = "addproduct", consumes = {MediaType.APPLICATION_JSON_VALUE})
//	public Product addproduct( @RequestBody Product product) {
//		return service.addproduct(product);
//	}
	
	//變更商品(明細)上下架狀態
	@PostMapping("updateProDesStatusOfShelf")
	public Core updateProDesStatusOfShelf(@RequestBody ProductDesVO prodes, Core core) {
		System.out.println("in update prodes Status");
		Core core1 = service.updateProDesStatusOfShelf(prodes.getStatus(),prodes.getProductDesId(), core);
//		System.out.println(prodes.getProductDesId());
//		System.out.println(prodes.getStatus());
		return core1;
	}
	
	//新增商品
	@PostMapping("addproduct")
	public Integer addProduct(@RequestBody Product product, @RequestBody ProductDesVO productdesVO) {
		int result = service.addProduct(product,productdesVO);
		return result;
	}
	
}
