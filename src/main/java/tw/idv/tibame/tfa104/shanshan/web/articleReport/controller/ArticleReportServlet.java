package tw.idv.tibame.tfa104.shanshan.web.articleReport.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.articleReport.entity.ArticleReportVO;
import tw.idv.tibame.tfa104.shanshan.web.articleReport.service.impl.ArticleReportService;


@WebServlet("/ArticleReportServlet.do")
public class ArticleReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ArticleReportServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");
		
		if("artRepo".equals(action)) {
			Integer	member_id = new Integer(req.getParameter("member_id"));
			Integer	article_id = new Integer(req.getParameter("article_id"));
			Integer	article_report_reason = new Integer(req.getParameter("article_report_reason"));
			Timestamp now = new Timestamp(new java.util.Date().getTime()); 
			SimpleDateFormat ft = 
					new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss");
			ft.format(now);
			
			ArticleReportVO articleRepo = new ArticleReportVO();
			articleRepo.setArticle_id(article_id);
			articleRepo.setMember_id(member_id);
			articleRepo.setArticle_report_reason(article_report_reason);
			articleRepo.setArticle_report_date(now);
			
			ArticleReportService artRepoSvc = new ArticleReportService();
			artRepoSvc.insert(articleRepo);
			
		}
		
		
	}

}
