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

@WebServlet("/AllProductServlet")
public class AllProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int pageNum = 0;
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		if (pageNum !=0) {

			//取得頁數物件
			Page page = new Page();
			//設定目前頁數=JSP傳過來的參數
			page.setCurPage(pageNum);
			//設定每頁資料條數
			page.setPageStandard(20);
			int pageStandard = page.getPageStandard();
			//取得目前頁數
			int curPage =page.getCurPage();
			//取得總商品資料條數
			ShopService ssvc = new ShopServiceImpl();
			int totalRecord = ssvc.getTotalProRecord();
			page.setTotalRecord(totalRecord);
			//取得總頁數
			int totalPage = page.getTotalPage();
			//按頁數查詢資料
			for (int p= 1 ; p <= totalPage ; p++) {
				if (curPage == p) {

					List<ProductBO> listAllProductBO = ssvc.findAllProduct((curPage-1)*10,pageStandard);

					request.setAttribute("listAllProductBO", listAllProductBO);
					request.getRequestDispatcher("/shop/goods_all_products.jsp").forward(request, response);
				}
			}
			
			
		}
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


