package tw.idv.tibame.tfa104.shanshan.web.admin.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Admin;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Order;

public interface AdminDAO {

	List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId);

	List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus);

//	Integer updateArticle(ArticleVO articleVO);

	Integer updateArticle(Article article);

	List<Admin> findAll();

	Integer updateAdmin(Admin admin);

	List<Order> findAllByDateRangePayStatus(String fromDate, String toDate, Integer paymentStatus);

	List<Order> findAllByPayStatus(Integer payment_status);

//	List<Order> periodProfit(String fromDate, String toDate, Integer paymentStatus);

}
