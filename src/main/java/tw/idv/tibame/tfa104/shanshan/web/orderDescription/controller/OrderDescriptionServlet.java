package tw.idv.tibame.tfa104.shanshan.web.orderDescription.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.OrderDescriptionServiceYYYY;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.impl.OrderDescriptionServiceImplYYYY;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

@WebServlet("/orderDescriptionServlet")
public class OrderDescriptionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
//		調用service方法
//		orderDescriptionService service = new orderDescriptionServiceImpl();
//		List<ProductBO> popular10 = service.findpopular10();
//		response.getWriter().print(popular10);
//		request.setAttribute("Pop", popular10);

//		request.getRequestDispatcher("shop/goods_index.jsp").forward(request, response); 
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


