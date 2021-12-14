package tw.idv.tibame.tfa104.shanshan.web.article.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;

public interface ArticleDAO_interface {
	 public void insert(ArticleVO ArticleVO);
     public void update(ArticleVO ArticleVO);
     public void delete(Integer article_id);
     public ArticleVO findByPrimaryKey(Integer article_id);
     public List<ArticleVO> getAll();
     public void updateviews(Integer aritcle_viewer, Integer article_id);
     public void updatepoints(Integer article_points_recieved, Integer article_id);
     
 	//自增主鍵值
     public String insertWithPic(ArticleVO ArticleVO , List<ArticlePictureVO> articlePictureVO);
//     public String insertWithPic(ArticleVO ArticleVO , ArticlePictureVO articlePictureVO);
     
     //顯示瀏覽數、打賞數
     public ArticleVO views(Integer article_id);
     public ArticleVO recievedPoints(Integer article_id);
     
     //排序:日期、瀏覽數、打賞數、推薦度
     public List<ArticleVO> orderByDate();
     public List<ArticleVO> orderByViewer();
     public List<ArticleVO> orderByRecievedPoints();
     public List<ArticleVO> orderByRecomm();
     
     //查詢
     public List<ArticleVO>search(String article_title,String article_content, String member_name,String mountain_name);
     
     //給member後台使用  to athnea

     public List<ArticleVO> findByMemIdGiveAll(Integer member_id);
     public ArticleVO memIdRecievedPoints(Integer member_id);
     
     //網誌狀態 to owen
     public int updateArticleStatus(Integer Article_status, Integer article_id);

     
}
