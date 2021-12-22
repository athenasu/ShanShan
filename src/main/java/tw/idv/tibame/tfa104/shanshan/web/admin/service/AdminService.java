package tw.idv.tibame.tfa104.shanshan.web.admin.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;

public interface AdminService {

//	List<ArticleReportVO> findArticleRepoByStatus(Integer articleReportStatus);

	List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId);

	List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus);

	Integer updateArticle(Article article);

}