package tw.idv.tibame.tfa104.shanshan.web.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.admin.service.AdminService;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;


@RestController
@RequestMapping("admin")
@SessionAttributes({ "admin" })
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin
	@GetMapping("findArticleRepoByStatus")
	public List<ArticleReportVO> findArticleRepoByStatus(Integer articleReportStatus){
		final List<ArticleReportVO> articlelist = adminService.findArticleRepoByStatus(articleReportStatus);
		return articlelist;
	}
}
