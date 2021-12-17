package tw.idv.tibame.tfa104.shanshan.web.articleReport.dao;

import java.sql.Date;
import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;


public interface ArticleReportDAO_interface {
	
	 public void insert(ArticleReportVO ArticleReportVO) ;
     public void updateArticleRepo(ArticleReportVO ArticleReportVO);
     public void deleteArticleRepo(Integer article_report_id);
     public List<ArticleReportVO> getAllArticleRepo();
     public ArticleReportVO findByArticleRepoPK(Integer article_report_id);

     
//   to Owen

     //依狀態搜尋 (0:未處理 1:已刪除 2:未通過)
     public List<ArticleReportVO> findArticleRepoByStatus(Integer article_report_status);
   
     //更改檢舉狀態(0:未處理 1:已刪除 2:未通過)
     public int updateArticleRepoStatus(Integer article_report_status,Date case_done , Integer article_id);
}
