package tw.idv.tibame.tfa104.shanshan.web.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.tibame.tfa104.shanshan.web.admin.dao.AdminDAO;
import tw.idv.tibame.tfa104.shanshan.web.admin.service.AdminService;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.dao.impl.ArticleReportDAO;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO dao;
	private ArticleReportDAO artdao;

	
	@Override
	public List<ArticleReportVO> findArticleRepoByStatus(Integer articleReportStatus) {
		return artdao.findArticleRepoByStatus(articleReportStatus);
	}
	

}
