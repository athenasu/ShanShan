package tw.idv.tibame.tfa104.shanshan.web.actLogMsg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.entity.ActLogMsgVO;
import tw.idv.tibame.tfa104.shanshan.web.actLogMsg.service.impl.ActLogMsgService;
import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.article.service.impl.ArticleService;

@WebServlet("/ActLogMsgServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ActLogMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ActLogMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");
		
		if ("sendMsg".equals(action)) {
			
			Integer member_id = new Integer(req.getParameter("member_id"));
			Integer article_id = new Integer(req.getParameter("article_id"));
			String msg_content = req.getParameter("msg_content");
			
			ActLogMsgVO actLogMsgVO = new ActLogMsgVO();
			actLogMsgVO.setArticle_id(article_id);
			actLogMsgVO.setMember_id(member_id);
			actLogMsgVO.setMsg_content(msg_content);
			
			ActLogMsgService actLogMsgSvc =new ActLogMsgService();
			actLogMsgSvc.insertMsg(actLogMsgVO);
			
			
			ArticleService artSvc = new ArticleService();
			ArticleVO articleVO = new ArticleVO();
			
			articleVO = artSvc.getOneArticle(article_id);
			req.setAttribute("articleVO", articleVO);
			
		}
		
		
	}

}
