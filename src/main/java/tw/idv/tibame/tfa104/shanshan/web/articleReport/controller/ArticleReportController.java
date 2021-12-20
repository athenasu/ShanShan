package tw.idv.tibame.tfa104.shanshan.web.articleReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.service.ReportService;
import tw.idv.tibame.tfa104.shanshan.web.core.Core;

@RestController
@RequestMapping("articleReport")
public class ArticleReportController {
	
	@Autowired
	private ReportService service;
	
	@PostMapping(path = "changeStatus", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public Core changeStatus(@RequestBody ArticleReportVO articleReport, Core core) {
		int result = service.changeStatus(articleReport.getArticle_report_id(),
										  articleReport.getArticle_report_status(),
										  articleReport.getCase_done());
		if (result > 0) {
			core.setSuccessful(true);
		} else {
			core.setSuccessful(false);
		}
		return core;
	}

}
