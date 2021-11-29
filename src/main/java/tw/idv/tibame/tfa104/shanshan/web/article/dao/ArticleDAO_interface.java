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
   
     
     //給member後台使用  to athnea
     //     memid (小卡(網誌該有的都要有含照片)、日曆要有mtn(需要經緯度)=>要join山、照片的表格、所以網誌join後資料全給)
     //     member_id 收到多少點數
//     public ArticleVO findByMemIdGiveAll(Integer member_id);
     public List<ArticleVO> findByMemIdGiveAll(Integer member_id);
     public ArticleVO memIdRecievedPoints(Integer member_id);
     
     //網誌狀態 to owen
     public int updateArticleStatus(Integer Article_status, Integer article_id);

}
