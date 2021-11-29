package tw.idv.tibame.tfa104.shanshan.web.articlePicture.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.ArticlePictureService;

@WebServlet("/ArticlePictureServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ArticlePictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticlePictureServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");

		if ("add".equals(action)) {

			byte[] article_picture = null;
			int article_id=2019;//測試用
			try {
//				Part part = req.getPart("article_picture");

				InputStream in = req.getPart("article_picture").getInputStream();
				article_picture = new byte[in.available()];

				in.read(article_picture);
				in.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();
			ArticlePictureVO.setArticle_picture(article_picture);
			ArticlePictureVO.setArticle_id(article_id);

//			=====2修改資料=====
			ArticlePictureService articlePictureSVC = new ArticlePictureService();
			ArticlePictureVO = articlePictureSVC.insert(article_id, article_picture);

//			=====3修改完成=====

//			req.setAttribute("ArticlePictureVO", ArticlePictureVO);
//			String url ="/article/addArticle.jsp";
//			req.getRequestDispatcher(url);

		}

		if ("getOneImage".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();

			try {
				int article_id = Integer.parseInt(req.getParameter("article_id"));
				ArticlePictureService artPicSvc = new ArticlePictureService();
				ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO = artPicSvc.getOnePic(article_id);
				byte[] pic = null;
				pic = ArticlePictureVO.getArticle_picture();
				out.write(pic);
				out.flush();
			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}
	}
}