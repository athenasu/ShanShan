package tw.idv.tibame.tfa104.shanshan.web.company.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyProductService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;
import tw.idv.tibame.tfa104.shanshan.web.product.dao.ProductDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.ProductDesVO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.dao.ProductImgDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgVO;

@Service
@Transactional
public class CompanyProductServiceImpl implements CompanyProductService {

	@Autowired
	private ProductDAOHibernate productDao;
	@Autowired
	private ProductDesDAOHibernate proDesDao;
	@Autowired
	private ProductImgDAO_interface proImgDao;
	
	//商品修改=========================================================
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
	
	
	//商品新增=========================================================
	@Override
	public Integer addProduct(Product product) {
		return productDao.addproduct(product);
	}

	@Override
	public Integer addProdes(ProductDesVO productdesVO) {
		return proDesDao.addProdes(productdesVO);
	}
	
	@Override
	public ProductImgVO addProImg(ProductImgVO productImgVO) {
		return proImgDao.addProImg(productImgVO);
	}
	
	
	//===========================================================
	@Override
	public List<FindByProductIdBO> findByPK(Integer prodesId) {
		return proDesDao.findByPK(prodesId);
	}

	@Override
	public List<ProductImgVO> findByproDes(Integer productDesId) {
		return proImgDao.findByproDes(productDesId);
	}
	@Override
	public List<ProductBO> findByCompanyId(Integer companyId) {
		return productDao.findByCompanyId(companyId);
	}





	
	

}
