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
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.OrderDescriptionService;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.service.impl.OrderDescriptionServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;

@WebServlet("/orderDescriptionServlet")
public class OrderDescriptionServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
//		調用service方法
//		OrderDescriptionService service = new OrderDescriptionServiceImpl();
//		List<OrderDescriptionBO> popular10 = service.BOfindByMemIdForMembCentr(1);
//		System.out.println(popular10);
//		response.getWriter().print(popular10);
//		request.setAttribute("Pop", popular10);

//		request.getRequestDispatcher("shop/goods_index.jsp").forward(request, response); 
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


