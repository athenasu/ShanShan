package tw.idv.tibame.tfa104.shanshan.web.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.service.AdminService;


@RestController
@RequestMapping("admin")
@SessionAttributes({ "admin" })
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@CrossOrigin
	@GetMapping("findArticleReportByStatus")
	public List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus){
		final List<ArticleReportBO> articlelist = adminService.findArticleReportByStatus(articleReportStatus);
		return articlelist;
	}
	
	@CrossOrigin
	@GetMapping("findArticleReportById")
	public List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId){
		final List<ArticleReportDetailBO> findbyid = adminService.findArticleReportById(articleReportId);
		return findbyid;
	}
	
	@CrossOrigin
	@PutMapping(path = "updateArticle", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer updateArticle(@RequestBody Article article) {
		return adminService.updateArticle(article);
	}
}
