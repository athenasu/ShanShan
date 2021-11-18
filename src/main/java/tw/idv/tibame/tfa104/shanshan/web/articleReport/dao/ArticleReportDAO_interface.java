package tw.idv.tibame.tfa104.shanshan.web.articleReport.dao;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;


public interface ArticleReportDAO_interface {
	
	 public void insert(ArticleReportVO ArticleReportVO) ;
	 public void update(ArticleReportVO ArticleReportVO) ;
//     public void delete(Integer article_report_id) ;
     public ArticleReportVO findByPrimaryKey(Integer article_report_id);
     public List<ArticleReportVO> getAll() ;
     
//     Report_article
//     1. 案件狀態：Select by status *3
//     2. 排序最新：Select by id desc
//     3. 給管理端：Update status
     //依狀態搜尋 (0:未處理 1:已刪除 2:未通過)
     public ArticleReportVO findByStatus0(Integer article_report_status);
     public ArticleReportVO findByStatus1(Integer article_report_status);
     public ArticleReportVO findByStatus2(Integer article_report_status);
     //排序最新(狀態0)
     public ArticleReportVO orderBydateS0(Integer article_report_status);

}
