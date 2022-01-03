package tw.idv.tibame.tfa104.shanshan.web.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Admin;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Article;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.ArticleReportDetailBO;
import tw.idv.tibame.tfa104.shanshan.web.admin.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.admin.service.AdminService;

@RestController
@RequestMapping("admin")
@SessionAttributes({ "admin" })
public class AdminController {
	@Autowired
	private AdminService adminService;

	@CrossOrigin
	@GetMapping("findAll")
	public List<Admin> findAll() {
		final List<Admin> adminAll = adminService.findAll();
		return adminAll;
	}

	@CrossOrigin
	@PostMapping("updateAdmin")
	public Integer updateAdmin(Admin admin) {
		return adminService.updateAdmin(admin);
	}

	@CrossOrigin
	@GetMapping("findArticleReportByStatus")
	public List<ArticleReportBO> findArticleReportByStatus(Integer articleReportStatus) {
		final List<ArticleReportBO> articlelist = adminService.findArticleReportByStatus(articleReportStatus);
		return articlelist;
	}

	@CrossOrigin
	@GetMapping("findArticleReportById")
	public List<ArticleReportDetailBO> findArticleReportById(Integer articleReportId) {
		final List<ArticleReportDetailBO> findbyid = adminService.findArticleReportById(articleReportId);
		return findbyid;
	}

	@CrossOrigin
	@PutMapping(path = "updateArticle", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Integer updateArticle(@RequestBody Article article) {
		return adminService.updateArticle(article);
	}

	@CrossOrigin
	@GetMapping(path = "findAllByPayStatus", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<Order> findAllByPayStatus(Integer payment_status) {
		return adminService.findAllByPayStatus(payment_status);
	}

	@CrossOrigin
	@GetMapping(path = "findAllByDateRangePayStatus", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<Order> findAllByDateRangePayStatus(String fromDate, String toDate, Integer paymentStatus) {
		return adminService.findAllByDateRangePayStatus(fromDate, toDate, paymentStatus);
	}

//	@CrossOrigin 
//	@GetMapping(path="periodProfit",consumes={MediaType.APPLICATION_JSON_VALUE})
//	public List<Order> periodProfit(String fromDate, String toDate, Integer paymentStatus) {
//		return adminService.periodProfit(fromDate, toDate, paymentStatus);
//	}
}
