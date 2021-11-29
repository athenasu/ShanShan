package tw.idv.tibame.tfa104.shanshan.web.productDescription.service.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.productDescription.dao.ProductDesDAOHibernate;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.entity.FindByProductIdBO;
import tw.idv.tibame.tfa104.shanshan.web.productDescription.service.ProductDesService;
@Service
@Transactional
public class ProductDesService_impl implements ProductDesService {
	@Autowired
	private ProductDesDAOHibernate dao;
	
	@Override
	public List<FindByProductIdBO> findByProductId(Integer productId){
		List <FindByProductIdBO> boList = dao.findByProductId(productId);
		for(FindByProductIdBO bo : boList) {
			bo.setPicStr(Base64.getEncoder().encodeToString(bo.getProductImg()));
		}
		return boList;
	}

	@Override
	public List<FindByProductIdBO> findByPK(Integer prodesId) {
		List <FindByProductIdBO> desList = dao.findByPK(prodesId);
		for(FindByProductIdBO des : desList) {
			des.setPicStr(Base64.getEncoder().encodeToString(des.getProductImg()));
		}
		return desList;
	}

	@Override
	public List<FindByProductIdBO> findByStock(Integer prodesStock) {
		List <FindByProductIdBO> stockList = dao.findByStock(prodesStock);
		for(FindByProductIdBO sto : stockList) {
			sto.setPicStr(Base64.getEncoder().encodeToString(sto.getProductImg()));
		}
		return stockList;
	}

	@Override
	public List<FindByProductIdBO> getAll() {
		List<FindByProductIdBO> allList = dao.getAll();
		for(FindByProductIdBO all : allList) {
			all.setPicStr(Base64.getEncoder().encodeToString(all.getProductImg()));
		}
		return allList;
	}
	
	
}
