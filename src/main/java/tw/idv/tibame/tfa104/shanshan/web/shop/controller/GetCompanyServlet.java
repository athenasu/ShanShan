package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/GetCompanyServlet")
public class GetCompanyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//來源路徑<%=contextPath %>/GetComapnytServlet?comapnyId=${comapnyBO.comapnyId}

		int company_id = 0;
		
		if(request.getParameter("companyId") != null) {
			company_id = Integer.parseInt(request.getParameter("companyId"));
		}
		
//		顯示商店細節
		ShopService service = new ShopServiceImpl();
		CompanyVO companyDetail = service.findCompanyByComId(company_id);
		request.setAttribute("companyDetail", companyDetail);

//		我們的商品區域 顯示5筆資料
		List<ProductBO> ourProduct = service.findProductByComId(company_id,0,5);
		request.setAttribute("ourProduct", ourProduct);

//		顯示COMPANY BANNER
		String action = request.getParameter("action");
		if ("companyBanner".equals(action)) {
			ServletOutputStream out = response.getOutputStream();
			
			try {
			byte[] companyBanner = null;
			companyBanner = companyDetail.getCompanyBanner();
			out.write(companyBanner);
			out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		} 
		
//		傳值到JSP
		request.getRequestDispatcher("shop/goods_store_page.jsp").forward(request, response);


	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


