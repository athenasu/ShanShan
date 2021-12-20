package tw.idv.tibame.tfa104.shanshan.web.admin.service;

import java.util.List;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;

public interface AdminService {

	List<ArticleReportVO> findArticleRepoByStatus(Integer articleReportStatus);

}
