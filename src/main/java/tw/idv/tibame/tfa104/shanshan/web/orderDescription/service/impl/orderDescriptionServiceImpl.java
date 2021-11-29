package tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.OrderDescriptionDAO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.dao.impl.OrderDescriptionDAOImpl;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.orderDescriptionService;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

public class orderDescriptionServiceImpl implements orderDescriptionService{

	OrderDescriptionDAO dao = new OrderDescriptionDAOImpl();
	

//	查詢 訂單明細 BY PK
	@Override
	public OrderDescription findByOrderDesId(Integer order_des_id) {
		return dao.findByOrderDesId(order_des_id);
	}

//	查詢 全部訂單明細 按order_des_id 倒序
	@Override
	public List<OrderDescription> findAll() {
		return dao.findAll();
	}


//	查詢 特定訂單的訂單明細 按訂單明細編號 正序
	@Override
	public OrderDescription findByOrderId(Integer order_id) {
		return dao.findByOrderId(order_id);
	}

//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (圖片是pro_des第一張圖)
	@Override
	public List<OrderDescriptionBO> BOfindByOrderId(Integer order_id) {
		return dao.BOfindByOrderIdNopic(order_id);
	}

//	查詢 特定訂單的訂單明細BO 按訂單明細編號 正序 (沒圖片)
	@Override
	public List<OrderDescriptionBO> BOfindByOrderIdNopic(Integer order_id) {
		return dao.BOfindByOrderIdNopic(order_id);
	}


	//	回傳10個 PopularProduct , 熱門商品 (10個)  按總銷售數 正序
	@Override
	public List<ProductBO> findpopular10() {
		return dao.findpopular10();
	}

	

}
