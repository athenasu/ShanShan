package tw.idv.tibame.tfa104.shanshan.web.articlePicture.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.service.impl.ArticlePictureService;
import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;
import tw.idv.tibame.tfa104.shanshan.web.mountain.service.MountainService;

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

//		if ("add".equals(action)) {

//			多張圖片上傳
//			Collection<Part> parts = req.getParts();
//			byte[] article_picture= null;
//			int article_id = 2019;
//			
//			
//			for (Part part : parts) {
//				InputStream in = part.getInputStream();
//				article_picture = new byte[in.available()];
////				System.out.println(article_picture);
//				in.read(article_picture);
////				System.out.println(in);
//				in.close();
//				
////				out.println("buffer length: " + buf.length);
////				System.out.println(ArticlePictureVO);
//				ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();
//				ArticlePictureVO.setArticle_picture(article_picture);
////				System.out.println(ArticlePictureVO);
//				ArticlePictureVO.setArticle_id(article_id);
//				
//				ArticlePictureService articlePictureSVC = new ArticlePictureService();
//				ArticlePictureVO = articlePictureSVC.insert(article_id, article_picture);
//			}
			

			
//	============================================================
//			byte[] article_picture = null;
//			int article_id = 2019;// 測試用
//			try {
////			Part part = req.getPart("article_picture");
//				InputStream in = req.getPart("article_picture").getInputStream();
//				
//				article_picture = new byte[in.available()];
//
//				in.read(article_picture);
//				in.close();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

//			ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();
//			ArticlePictureVO.setArticle_picture(article_picture);
//			ArticlePictureVO.setArticle_id(article_id);

//			=====2修改資料=====
//			ArticlePictureService articlePictureSVC = new ArticlePictureService();
//			ArticlePictureVO = articlePictureSVC.insert(article_id, article_picture);

//			=====3修改完成=====

//			req.setAttribute("ArticlePictureVO", ArticlePictureVO);
//			String url ="/article/addArticle.jsp";
//			req.getRequestDispatcher(url);

//		}

		if ("getOneImage".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();
//			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
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

		if ("getImage".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();

			try {
				int member_id = Integer.parseInt(req.getParameter("member_id"));
				WebApplicationContext context = WebApplicationContextUtils
						.getWebApplicationContext(getServletContext());
				MemberService memSvc = context.getBean(MemberService.class);
				Member member = new Member();
				member = memSvc.findById(member_id);
				byte[] pic = null;
				pic = member.getMemberProfilePic();
				out.write(pic);
				out.flush();
			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}

		if ("getArtPic".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();
			try {
				int article_picture_id = Integer.parseInt(req.getParameter("article_picture_id").trim());
				ArticlePictureService artPicSvc = new ArticlePictureService();
				ArticlePictureVO ArticlePictureVO = new ArticlePictureVO();
				ArticlePictureVO = artPicSvc.findByPicId(article_picture_id);
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
		if ("getMtnPic".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();
			try {
				int mountainId = Integer.parseInt(req.getParameter("mountainId"));
				WebApplicationContext context = WebApplicationContextUtils
						.getWebApplicationContext(getServletContext());
				MountainService mtnSvc = context.getBean(MountainService.class);
				Mountain mtn = new Mountain();
				mtn = mtnSvc.findMtnByPk(mountainId);
				byte[] pic = null;
				pic = mtn.getMountainPic();
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