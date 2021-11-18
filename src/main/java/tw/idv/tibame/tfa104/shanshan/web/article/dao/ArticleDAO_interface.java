package tw.idv.tibame.tfa104.shanshan.web.article.dao;

import java.util.*;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;

public interface ArticleDAO_interface {
	 public void insert(ArticleVO ArticleVO);
     public void update(ArticleVO ArticleVO);
     public void delete(Integer article_id);
     public ArticleVO findByPrimaryKey(Integer article_id);
     public List<ArticleVO> getAll();
     
     //顯示瀏覽數、打賞數
     public ArticleVO views(Integer article_id);
     public ArticleVO recievedPoints(Integer article_id);
     
     //排序:日期、瀏覽數、打賞數、推薦度
     public List<ArticleVO> orderByDate();
     public List<ArticleVO> orderByViewer();
     public List<ArticleVO> orderByRecievedPoints();
     public List<ArticleVO> orderByRecomm();
     
     //複合查詢後補
   
     

}
