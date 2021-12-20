package tw.idv.tibame.tfa104.shanshan.web.article.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.article.entity.ArticleVO;
import tw.idv.tibame.tfa104.shanshan.web.article.service.impl.ArticleService;
import tw.idv.tibame.tfa104.shanshan.web.articlePicture.entity.ArticlePictureVO;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.mountain.service.MountainService;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.wishlistArticle.service.WishlistArticleService;

@WebServlet(urlPatterns = { "/ArticleServlet.do" }, loadOnStartup = 1)
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleServlet() {
		super();
	}

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		MemberService memSvc = context.getBean(MemberService.class);
		application.setAttribute("memSvc", memSvc);
		

		MountainService mtnSvc = context.getBean(MountainService.class);
		application.setAttribute("mtnSvc", mtnSvc);
		
		EventService eventSvc = context.getBean(EventService.class);
		application.setAttribute("eventSvc", eventSvc);
		
		WishlistArticleService wishSvc = context.getBean(WishlistArticleService.class);
		application.setAttribute("wishSvc", wishSvc);
		
		ShopService shopsvc = new ShopServiceImpl();
		List<ProductBO> popular5 = shopsvc.findPopularNum(5);
		application.setAttribute("popular5",popular5);  
		
		

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");

//		System.out.println("----------------------------------------");

//		新增網誌
		if ("new".equals(action)) {
			
			Integer member_id = new Integer(req.getParameter("member_id"));
			String article_title = req.getParameter("article_title");
			Date event_date = java.sql.Date.valueOf(req.getParameter("event_date").trim());
			Integer mountain_id = new Integer(req.getParameter("mountain_id"));
			Integer recommendation = new Integer(req.getParameter("recommendation"));
			String article_content = req.getParameter("article_content");
			String other_mtn = req.getParameter("other_mtn");

			ArticleVO articleVO = new ArticleVO();
			articleVO.setMember_id(member_id);
			articleVO.setArticle_title(article_title);
			articleVO.setEvent_date(event_date);
			articleVO.setMountain_id(mountain_id);
			articleVO.setRecommendation(recommendation);
			articleVO.setArticle_content(article_content);
			articleVO.setOther_mtn(other_mtn);

			
			//單張上傳
//			byte[] article_picture = null;
//
//			InputStream in = req.getPart("article_picture").getInputStream();
//			article_picture = new byte[in.available()];
//
//			in.read(article_picture);
//			in.close();
//
//			ArticlePictureVO articlePictureVO = new ArticlePictureVO();
//			articlePictureVO.setArticle_picture(article_picture);
			
			
//			將網誌及圖片放進資料庫
//			ArticleService articleSvc = new ArticleService();
//			String getCheck = articleSvc.insertWithPic(articleVO, articlePictureVO);
//			=========================================================================
			//測試多張圖片
			Collection<Part> parts = req.getParts();
			List<ArticlePictureVO> list = new ArrayList<ArticlePictureVO>();

			byte[] article_picture = null;
			for (Part part : parts) {
				if (part.getContentType()!=null && part.getContentType().contains("image/")) {
					InputStream in = part.getInputStream();
					article_picture = new byte[in.available()];
					in.read(article_picture);		
					in.close();	
					ArticlePictureVO articlePic = new ArticlePictureVO();
					articlePic.setArticle_picture(article_picture);
					list.add(articlePic);
				}

			}
			
				ArticleService articleSvc = new ArticleService();
				String getCheck=articleSvc.insertWithPic(articleVO, list);
//			================================================================================


			if ("ok".equals(getCheck)) {

				// 發表成功給五點
				WebApplicationContext context = WebApplicationContextUtils
						.getWebApplicationContext(getServletContext());
				MemberService memSvc = context.getBean(MemberService.class);
				memSvc.updateMemberPoints(articleVO.getMember_id(), 5);

				// 新增成功後跳轉網誌列表
				String url = "/article/articleList.jsp";
				RequestDispatcher view = req.getRequestDispatcher(url);
				view.forward(req, res);
			} else {
// 				失敗跳轉首頁(暫定)
				String url = "/index/index.jsp";
				RequestDispatcher view = req.getRequestDispatcher(url);
				view.forward(req, res);

			}

		}

		if ("getThisArt".equals(action)) {
			Integer article_id = new Integer(req.getParameter("article_id"));

			ArticleService artSvc = new ArticleService();
			ArticleVO articleVO = artSvc.getOneArticle(article_id);
			req.setAttribute("articleVO", articleVO);

			// 點閱數+1
			int viewer = articleVO.getAritcle_viewer();
			viewer+=1 ;
			artSvc.updateviews(viewer, article_id);

			String url = "/article/article.jsp";
			RequestDispatcher view = req.getRequestDispatcher(url);
			view.forward(req, res);
		}

		if ("search".equals(action)) {
			String keyword = req.getParameter("keyword");

			ArticleService artSvc = new ArticleService();
			List<ArticleVO> articleVO = artSvc.search(keyword, keyword, keyword, keyword);
			// 如果查無結果，停在原頁面
			if (articleVO.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/article/articleList.jsp");
				failureView.forward(req, res);
			} else {
				// 如果有結果，轉到搜尋結果頁面
				req.setAttribute("articleVO", articleVO);
				RequestDispatcher view = req.getRequestDispatcher("/article/searchArticle.jsp");
				view.forward(req, res);
			}

		}
		if("addpoint".equals(action)) {
			Integer article_id = new Integer(req.getParameter("article_id"));
			Integer article_points_recieved = new Integer(req.getParameter("article_points_recieved"));

			ArticleService artSvc = new ArticleService();
			artSvc.updatepoints(article_points_recieved, article_id);
			
		}

		
	}
	
	

}
