package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("PurchaseServlet執行到了喔");
		
		String method = "";
		int productDesId = 0;
		int itemQTY = 0;
		
		if(request.getParameter("method") != null) {
		method = request.getParameter("method"); 
		};
		
//		PurchaseServlet?method=buyDirectly&productDesId=43&itemQTY=1
//		直接購買
		if ("buyDirectly".equals(method)) {
			if(request.getParameter("productDesId") != null) {
				productDesId = Integer.parseInt(request.getParameter("productDesId")); 
			};

			if(request.getParameter("itemQTY") != null) {
				itemQTY = Integer.parseInt(request.getParameter("itemQTY"));
			};
			
			OrderDescription orderDes = new OrderDescription();
			orderDes.setProduct_des_id(productDesId);
			orderDes.setProduct_quantity(itemQTY);

//			Integer order_des_id;
//			Integer order_id;
//			Integer product_price;
			System.out.println("buyDirectly執行到了喔");
			request.setAttribute("orderDes", orderDes);
			request.getRequestDispatcher("/shop/goods_payment_check.jsp").forward(request, response);
		};

//		從購物車購買
		if ("buyCart".equals(method)) {
			request.getRequestDispatcher("/shop/goods_payment_check.jsp").forward(request, response);
		};


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


