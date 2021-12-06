package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet(urlPatterns={"/ShopIndexDataServlet"},loadOnStartup = 1)
public class ShopIndexDataServlet extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("ShopIndexDataServlet  init()被調用了");
//		取得一個ServletContext物件
		ServletContext application = this.getServletContext();
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ProductServiceHibernate service = context.getBean(ProductServiceHibernate.class);
		List<ProductBO> latest10 =  (List<ProductBO>) service.findNew();
		application.setAttribute("latest10", latest10);
		

		ShopService shopsvc = new ShopServiceImpl();
		List<ProductBO> popular10 = shopsvc.findPopularNum(10);
		application.setAttribute("popular10",popular10);   
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
  
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


