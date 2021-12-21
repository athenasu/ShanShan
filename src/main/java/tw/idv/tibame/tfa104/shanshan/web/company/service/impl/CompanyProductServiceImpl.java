package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyProductService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.product.dao.ProductDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

@Service
@Transactional
public class CompanyProductServiceImpl implements CompanyProductService {

	@Autowired
	private ProductDAOHibernate productDao;
	private ProductDesDAOHibernate proDesDao;
	private ProductImgDAO_interface proImgDao;
	
	
	@Override
	public Core updateProDesStatusOfShelf(Integer prodesStatus, Integer prodesId, Core core) {
		int result = proDesDao.updateProDesStatusOfShelf(prodesStatus, prodesId);
		if(result == 1) {
			core.setSuccessful(true);
			return core;
		}else {
			core.setSuccessful(false);
			return core;
		}
		
	}

	@Override
	public Integer addProduct(Product product,ProductDesVO productdesVO) {
		 Integer productId = productDao.addproduct(product);
		 productdesVO.setProductId(productId);
		 Integer productDesId = proDesDao.addProdes(productdesVO);
		 return productDesId;
//		 proDesDao.addProdes(productdesVO)
//		 proDesDao.addProdes(productDesVO);
//		 proImgDao.addProImg(productImgVO);
		 
	}

	

}
