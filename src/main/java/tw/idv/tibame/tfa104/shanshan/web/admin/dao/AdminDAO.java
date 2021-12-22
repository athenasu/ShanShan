package tw.idv.tibame.tfa104.shanshan.web.admin.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Admin;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;

public interface AdminDAO {

	List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId);

	List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus);

//	Integer updateArticle(ArticleVO articleVO);

	Integer updateArticle(Article article);

	List<Admin> findAll();

	Integer updateAdmin(Admin admin);

}
