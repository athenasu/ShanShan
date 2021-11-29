package tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao.ArticlePictureDAO_interface;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao.impl.ArticlePictureDAO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;

public class ArticlePictureService {
	
	private ArticlePictureDAO_interface dao;
	
	public ArticlePictureService() {
		dao = new ArticlePictureDAO();
	}

	public ArticlePictureVO insert(Integer article_id, byte[] article_picture) {

		ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();		
		ArticlePictureVO.setArticle_id(article_id);
		ArticlePictureVO.setArticle_picture(article_picture);		
		dao.insert(ArticlePictureVO);
		return ArticlePictureVO;
	}

	public ArticlePictureVO update(Integer article_id, byte[] article_picture) {
		
		ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();		
		ArticlePictureVO.setArticle_id(article_id);
		ArticlePictureVO.setArticle_picture(article_picture);
		dao.update(ArticlePictureVO);
		return ArticlePictureVO;
	}

	public ArticlePictureVO findByArtId(Integer article_id) {
		return dao.findByArtId(article_id);
	}

	public void delete(Integer article_picture_id) {
		dao.delete(article_picture_id);
	}

	public List<ArticlePictureVO> getAllArtPic() {
		return dao.getAllArtPic();
	}

	public ArticlePictureVO getOnePic(Integer article_id) {
		return dao.getOnePic(article_id);
	}
	
	
}
