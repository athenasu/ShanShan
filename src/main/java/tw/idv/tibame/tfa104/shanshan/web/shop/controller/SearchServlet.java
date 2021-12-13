package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.company.service.CompanyServiecHibernate;
import tw.idv.tibame.tfa104.shanshan.web.company.service.impl.CompanyServiceHibernate_impl;
import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.member.service.impl.MemberServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.product.service.impl.ProductServiceHibernate_impl;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.CartItem;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {

		// 來源路徑<%=request.getContextPath()%>/SearchServlet?method=????& searchString=????????
		
		String searchString = "";
		String method = "";
		// 獲取參數
		if(request.getParameter("searchString") != null) {
			searchString = request.getParameter("searchString");
			searchString = URLEncoder.encode(searchString, "ISO-8859-1");
			searchString = URLDecoder.decode(searchString, "UTF-8");
		}

		if(request.getParameter("method") != null) {
			method = request.getParameter("method"); 
		}
		
		if ("product".equals(method)) {
			List<ProductBO> searchProductList = new ArrayList<ProductBO>();
//			調用搜尋字串方法

			ServletContext application = this.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ProductServiceHibernate productsrvc = context.getBean(ProductServiceHibernate_impl.class);
			
			searchProductList = productsrvc.findProdNameByString(searchString);
			
//			儲存到request
			request.setAttribute("searchProductList", searchProductList);
			request.getRequestDispatcher("/shop/goods_search_products.jsp").forward(request, response);
		}
		
		if ("company".equals(method)) {
			List<CompanyVO> searchCompanyList = new ArrayList<CompanyVO>();
//			調用搜尋公司方法

			ServletContext application = this.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			CompanyServiecHibernate companysrvc = context.getBean(CompanyServiceHibernate_impl.class);
			searchCompanyList =	companysrvc.findComByString(searchString);
					
//			儲存到request
			request.setAttribute("searchCompany", searchCompanyList);
			request.getRequestDispatcher("/shop/goods_search_store.jsp").forward(request, response);
		}
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}
	
}
