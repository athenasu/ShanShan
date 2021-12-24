package tw.idv.tibame.tfa104.shanshan.web.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.tibame.tfa104.shanshan.web.admin.dao.AdminDAO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Admin;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.admin.service.AdminService;



@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO dao;
//	private ArticleDAO artdao;
//	private OrderDAO orderdao;

	@Override
	public List<Admin> findAll() {
		return dao.findAll();
	} 
	
	@Override 
	public Integer updateAdmin(Admin admin){
		return dao.updateAdmin(admin);
	}
	@Override
	public List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus) {
		return dao.findArticleReportByStatus(articleReportStatus);
	}
	
	@Override
	public List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId){
		return dao.findArticleReportById(articleReportId);
	}

	@Override
	public Integer updateArticle(Article article) {
		return dao.updateArticle(article);
	}
	
	@Override
	public List<Order> findAllByPayStatus(Integer payment_status) {
		return dao.findAllByPayStatus(payment_status);
	}
	
	@Override
	public List<Order> findAllByDateRangePayStatus(String fromDate, String toDate,Integer paymentStatus) {
		return dao.findAllByDateRangePayStatus(fromDate, toDate, paymentStatus);
	}
	
//	@Override
//	public List<Order> periodProfit(String fromDate, String toDate, Integer paymentStatus) {
//		return dao.periodProfit(fromDate, toDate, paymentStatus);
//	}

}
