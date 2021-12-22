package tw.idv.tibame.tfa104.shanshan.web.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tw.idv.tibame.tfa104.shanshan.web.admin.dao.AdminDAO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Admin;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Admin> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery("SELECT * " + "FROM Admin", Admin.class).list();
	}

	@Override
	public Integer updateAdmin(Admin admin){
		Session session = sessionFactory.getCurrentSession();
		Admin tempAdmin = session.get(Admin.class, admin.getAdminId());
			
		final Integer adminId = admin.getAdminId();
		if(adminId != null) {
			tempAdmin.setAdminId(adminId);
		}
		
		session.update(tempAdmin);
		return 1;
		
}

	@Override
	public List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus) {
		Session session = sessionFactory.getCurrentSession();
		return session.createNativeQuery(
				"SELECT " + "article_report_id as articleReportId, " + "member_id as memberId, "
						+ "article_id as articleId, " + "article_report_status as articleReportStatus, "
						+ "article_report_reason as articleReportReason, "
						+ "article_report_date as articleReportDate, " + "case_done as caseDone "
						+ "FROM article_report " + "WHERE article_report_status = :articleReportStatus",
				ArticleReportBO.class).setParameter("articleReportStatus", articleReportStatus).list();
	}

	@Override
	public List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createNativeQuery("SELECT " + "a.article_report_id as articleReportId, " + "a.member_id as memberId, "
						+ "a.article_id as articleId, " + "a.article_report_date as articleReportDate, "
						+ "a.article_report_status as articleReportStatus, "
						+ "a.article_report_reason as articleReportReason, " + "a.case_done as caseDone, "
						+ "b.article_title as articleTitle, " + "b.article_content as articleContent, "
						+ "c.member_name as memberName, " + "c.member_username as memberUsername "
						+ "FROM article_report a " + "JOIN article b " + "ON a.article_id = b.article_id "
						+ "JOIN member c " + "ON a.member_id = c.member_id " + "WHERE "
						+ "a.article_report_id = :articleReportId", ArticleReportDetailBO.class)
				.setParameter("articleReportId", articleReportId).list();
	}

	@Override
	public Integer updateArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		Article tempArticle = session.get(Article.class, article.getArticleId());

		final Integer articleId = article.getArticleId();
		if (articleId != null) {
			tempArticle.setArticleId(articleId);
		}

		final Integer articleStatus = article.getArticleStatus();
		if (articleStatus != null) {
			tempArticle.setArticleStatus(articleStatus);
		}

		session.update(tempArticle);
		return 1;
	}
}
