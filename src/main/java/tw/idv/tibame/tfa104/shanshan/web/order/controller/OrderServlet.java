package tw.idv.tibame.tfa104.shanshan.web.order.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.order.service.OrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.service.impl.OrderServiceImpl;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		OrderService service = new OrderServiceImpl();
		
//		調用service方法
		
//		響應結果
		response.setContentType("application/json;charaset=utf-8");
//		response.getWriter().write();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
}
