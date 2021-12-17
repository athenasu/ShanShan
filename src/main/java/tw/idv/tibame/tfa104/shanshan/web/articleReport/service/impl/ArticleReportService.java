package tw.idv.tibame.tfa104.shanshan.web.articleReport.service.impl;

import java.sql.Date;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.ArticleReportDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.impl.ArticleReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;

public class ArticleReportService {

	private ArticleReportDAO_interface dao;

	public ArticleReportService() {
		dao = new ArticleReportDAO();
	}

	public void insert(ArticleReportVO ArticleReportVO) {
		dao.insert(ArticleReportVO);
	}

	public void updateArticleRepo(ArticleReportVO ArticleReportVO) {
		dao.updateArticleRepo(ArticleReportVO);
	}

	public void deleteArticleRepo(Integer article_report_id) {
		dao.deleteArticleRepo(article_report_id);
	}

	public List<ArticleReportVO> getAllArticleRepo() {
		return dao.getAllArticleRepo();
	}

	public ArticleReportVO findByArticleRepoPK(Integer article_report_id) {
		return dao.findByArticleRepoPK(article_report_id);
	}
	
	public List<ArticleReportVO> findArticleRepoByStatus(Integer article_report_status) {
		return dao.findArticleRepoByStatus(article_report_status);
	}

	public int updateArticleRepoStatus(Integer article_report_status, Date case_done, Integer article_id) {
		return dao.updateArticleRepoStatus(article_report_status, case_done, article_id);
	}

}
