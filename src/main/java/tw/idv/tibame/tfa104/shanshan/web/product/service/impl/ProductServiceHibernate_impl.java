package tw.idv.tibame.tfa104.shanshan.web.product.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.product.dao.ProductDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.Product;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;

@Service //tell spring this is a service
@Transactional //spring know 他需要幫忙控管交易
public class ProductServiceHibernate_impl implements  ProductServiceHibernate{
	@Autowired
	private ProductDAOHibernate dao;
	
	
	@Override
	public Integer addproduct(Product product) {
		return dao.addproduct(product);
	}
	@Override
	public List<ProductBO> findById(Integer productId) {
		List <ProductBO> proId = dao.findById(productId);
		for(ProductBO pro :proId) {
			pro.setPicStr(Base64.getEncoder().encodeToString(pro.getProductImg()));
		}
		return proId;
	}

	@Override
	public List<ProductBO> findNew() {
		List <ProductBO> newList = dao.findNew();
		for(ProductBO newpro : newList) {
			newpro.setPicStr(Base64.getEncoder().encodeToString(newpro.getProductImg()));
		}
		return newList;
	}

	@Override
	public List<ProductBO> findByCompanyName(String search){
		List<ProductBO> comSearch = dao.findByCompanyName(search);
		for(ProductBO com : comSearch) {
			com.setPicStr(Base64.getEncoder().encodeToString(com.getProductImg()));
		}
		return comSearch;
	}

	@Override
	public List<ProductBO> findProdNameByString(String search) {
		List<ProductBO> proSearch = dao.findProdNameByString(search);
		for(ProductBO pro : proSearch) {
			pro.setPicStr(Base64.getEncoder().encodeToString(pro.getProductImg()));
		}
		return proSearch;
	}

	@Override
	public List<ProductBO> findByType(Integer typeId) {
		List<ProductBO> typeSearch = dao.findByType(typeId);
		for(ProductBO type : typeSearch) {
			type.setPicStr(Base64.getEncoder().encodeToString(type.getProductImg()));
		}
		return typeSearch;
	}

	@Override
	public List<ProductBO> findByCompanyId(Integer companyId) {
		List<ProductBO> comIdSearch = dao.findByCompanyId(companyId);
		for(ProductBO comId : comIdSearch) {
			comId.setPicStr(Base64.getEncoder().encodeToString(comId.getProductImg()));
		}
		return comIdSearch;
	}

	@Override
	public List<ProductBO> getAll() {
		List<ProductBO> allList = dao.getAll();
		for(ProductBO all : allList) {
			all.setPicStr(Base64.getEncoder().encodeToString(all.getProductImg()));
		}
		return allList;
	}



	
	

}
