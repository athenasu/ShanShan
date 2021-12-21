package tw.idv.tibame.tfa104.shanshan.web.article.service.impl;

import java.sql.Date;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.dao.ArticleDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.article.dao.impl.ArticleDAO;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;

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
	
	

	public List<ArticleVO> findByMtn(Integer mountain_id) {
		return dao.findByMtn(mountain_id);
	}

	public ArticleVO views(Integer article_id) {
		return dao.views(article_id);
	}

	public ArticleVO recievedPoints(Integer article_id) {
		return dao.recievedPoints(article_id);
	}

	public List<ArticleVO> orderByDate() {
		return dao.orderByDate();
	}

	public List<ArticleVO> orderByViewer() {
		return dao.orderByViewer();
	}

	public List<ArticleVO> orderByRecievedPoints() {
		return dao.orderByRecievedPoints();
	}

	public List<ArticleVO> orderByRecomm() {
		return dao.orderByRecomm();
	}

	public List<ArticleVO> findByMemIdGiveAll(Integer member_id) {
		return dao.findByMemIdGiveAll(member_id);
	}

	public ArticleVO memIdRecievedPoints(Integer member_id) {
		return dao.memIdRecievedPoints(member_id);
	}

	public int updateArticleStatus(Integer article_status, Integer article_id) {
		return dao.updateArticleStatus(article_status, article_id);
	}

	
	public void updateviews(Integer aritcle_viewer, Integer article_id) {
		dao.updateviews(aritcle_viewer, article_id);
	}

	
	
	public void updatepoints(Integer article_points_recieved, Integer article_id) {

		dao.updatepoints(article_points_recieved, article_id);
	}

	public String insertWithPic(ArticleVO ArticleVO, List<ArticlePictureVO> articlePictureVO) {
           dao.insertWithPic(ArticleVO, articlePictureVO);
		   return "ok";
	}

	public List<ArticleVO> search(String article_title, String article_content, String member_name,
			String mountain_name) {
		return dao.search(article_title, article_content, member_name, mountain_name);
	}



	
}