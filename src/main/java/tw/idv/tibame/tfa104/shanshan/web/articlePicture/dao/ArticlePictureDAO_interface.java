package tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;


public interface ArticlePictureDAO_interface {
	
	 public void insert(ArticlePictureVO ArticlePictureVO) ;
	 public String update(ArticlePictureVO ArticlePictureVO) ;
     public ArticlePictureVO findByArtId(Integer article_id);
     public ArticlePictureVO getOnePic(Integer article_id);
     
     public void delete(Integer article_picture_id);
     public List<ArticlePictureVO> getAllArtPic();

 
}
