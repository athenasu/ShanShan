package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Page;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/GetProductTypeServlet")
public class GetProductTypeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		int productType = 0;
		int pageNum = 0;
		// 取得參數

		if (request.getParameter("ProductType") != null) {
			productType = Integer.parseInt(request.getParameter("ProductType"));
		}

		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}

		// 取得頁數物件
		Page page = new Page();
		// 設定目前頁數=JSP傳過來的參數
		page.setCurPage(pageNum);
		// 設定每頁資料條數
		page.setPageStandard(10);
		int pageStandard = page.getPageStandard();
//			//按目前頁數，跳轉對應頁數畫面
//			int curPage =page.getCurPage();
		// 取得商品類別總資料條數
		ShopService ssvc = new ShopServiceImpl();
		int totalRecord = ssvc.getTotalProRecordByType(productType);
		page.setTotalRecord(totalRecord);
		// 取得總頁數
		int totalPage = page.getTotalPage();

		// 按頁數查詢資料
		if (pageNum > totalPage) {
			System.out.println("本頁數不存在");			
		}else if (pageNum == 1) {
//			findAllProduct參數(忽略的資料數,每頁資料條數)
			List<ProductBO> listTypeProductBO = ssvc.findProductByType(productType, (pageNum - 1) * pageStandard,
					pageStandard);

			request.setAttribute("listTypeProductBO", listTypeProductBO);
			request.getRequestDispatcher("/shop/goods_single_kind_products.jsp").forward(request, response);
		}else if(pageNum > 1) {
//			findAllProduct參數(忽略的資料數,每頁資料條數)
			List<ProductBO> listAllProductBO = ssvc.findAllProduct((pageNum - 1) * pageStandard, pageStandard);

			response.setContentType("application/json;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			
			response.getWriter().print(listAllProductBO);
			response.getWriter().flush();
			response.getWriter().close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}
}
