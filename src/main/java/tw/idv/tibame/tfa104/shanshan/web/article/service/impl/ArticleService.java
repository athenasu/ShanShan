package tw.idv.tibame.tfa104.shanshan.web.article.service.impl;

import java.sql.Date;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.dao.impl.ArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;

public class ArticleService {
	private ArticleDAO_interface dao;

	public ArticleService() {
		dao = new ArticleDAO();
	}

	public ArticleVO addArticle(Integer member_id, Integer mountain_id, String article_title, String article_content,
			Date event_date, Integer recommendation, String other_mtn) {

		ArticleVO ArticleVO = new ArticleVO();

		ArticleVO.setMember_id(member_id);
		ArticleVO.setMountain_id(mountain_id);
		ArticleVO.setArticle_title(article_title);
		ArticleVO.setArticle_content(article_content);
		ArticleVO.setEvent_date(event_date);
		ArticleVO.setRecommendation(recommendation);
		ArticleVO.setOther_mtn(other_mtn);
		dao.insert(ArticleVO);

		return ArticleVO;
	}

	public ArticleVO updateArticle(Integer member_id, Integer mountain_id, String article_title, String article_content,
			Date event_date, Integer recommendation, String other_mtn) {

		ArticleVO ArticleVO = new ArticleVO();

		ArticleVO.setMountain_id(mountain_id);
		ArticleVO.setArticle_title(article_title);
		ArticleVO.setArticle_content(article_content);
		ArticleVO.setEvent_date(event_date);
		ArticleVO.setRecommendation(recommendation);
		ArticleVO.setOther_mtn(other_mtn);
		dao.update(ArticleVO);

		return ArticleVO;
	}

	public void deleteArticle(Integer article_id) {
		dao.delete(article_id);
	}

	public ArticleVO getOneArticle(Integer article_id) {
		return dao.findByPrimaryKey(article_id);
	}

	public List<ArticleVO> getAll() {
		return dao.getAll();
	}

}