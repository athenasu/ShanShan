package tw.idv.tibame.tfa104.shanshan.web.articlePicture.dao;

import java.util.*;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;


public interface ArticlePictureDAO_interface {
	
	 public void insert(ArticlePictureVO ArticlePictureVO) ;
	 public void update(ArticlePictureVO ArticlePictureVO) ;
     public void delete(Integer article_picture_id) ;
     public ArticlePictureVO findByPrimaryKey(Integer article_picture_id);
//     public List<ArticlePictureVO> getAll() ;
     
     
}
