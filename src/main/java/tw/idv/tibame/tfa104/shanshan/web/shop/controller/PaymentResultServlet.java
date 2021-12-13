package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.order.service.OrderService;
import tw.idv.tibame.tfa104.shanshan.web.order.service.impl.OrderServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/PaymentResultServlet")
public class PaymentResultServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		url http://localhost:8081/shanshan/PaymentResultServlet?fill_name=%E7%8E%8B%E6%9B%89%E6%98%8E&fill_phone=0912123012&address=%E5%8F%B0%E5%8C%97%E5%B8%82%E5%8D%97%E5%8D%80%E4%B8%80%E6%A2%9D%E8%B7%AF20%E8%99%9F4%E6%A8%93&0point=0&1point=0&expire_month=&expire_year=&payment_fill_CVN=

		ShopService service = new ShopServiceImpl();
		OrderService ordersrvc = new OrderServiceImpl();
//		取得Session
		HttpSession session = request.getSession();

//		如果任一參數為空，回到首頁
		if (session.getAttribute("cart") == null || session.getAttribute("orderList") == null
				|| session.getAttribute("memberId") == null || request.getParameter("fill_name") == null
				|| request.getParameter("fill_phone") == null || request.getParameter("address") == null) {
//			response.sendRedirect("/shop/goods_index.jsp");
			System.out.println("有東西為空喔");
		}
//		取得購物車
		Cart cart = (Cart) session.getAttribute("cart");
//		取得結帳清單
		List<Order> orderList = (List<Order>) session.getAttribute("orderList");
//		取得訂單數
		int orderQTY = orderList.size();
//		取得會員ID
		int memberId = (int) session.getAttribute("memberId");

		List<Order> finalOrderList = new ArrayList<Order>();
//		取得參數
//		System.out.println("============");
//		System.out.println("memberId===="+memberId);
//		System.out.println("orderList==="+orderList);
//		System.out.println("Cart==="+cart);
//		System.out.println((Integer) request.getAttribute( 0 + "point"));
//		System.out.println((String) request.getAttribute("address"));
//		System.out.println((String) request.getAttribute("fill_name"));
//		System.out.println((Integer) request.getAttribute("fill_phone"));
//		System.out.println((Integer) request.getAttribute( 0 + "sumAfter"));
//		System.out.println("============");
//		補全 結帳清單中 的 訂單資料
		int makeOrderOK = 0;
		int cartProDesId = 0;
		String address = "";
		String fillName = "";

		for (int i = 0; i < orderQTY; i++) {

			orderList.get(i).setPoint_used(Integer.parseInt(request.getParameter(i + "point"))); // 0point=?? 1point=??
			orderList.get(i).setOrder_member_phone(Integer.parseInt(request.getParameter("fill_phone")));
			orderList.get(i).setOrder_sum_after(Integer.parseInt(request.getParameter(i + "sumAfter")));

			address = request.getParameter("address");
			address = URLEncoder.encode(address, "ISO-8859-1");
			address = URLDecoder.decode(address, "UTF-8");
			orderList.get(i).setOrder_member_address(address);
			System.out.println("解碼後的收件人地址:" + address);

			fillName = request.getParameter("fill_name");
			fillName = URLEncoder.encode(fillName, "ISO-8859-1");
			fillName = URLDecoder.decode(fillName, "UTF-8");
			orderList.get(i).setOrder_member_name(fillName);
			System.out.println("解碼後的收件人姓名:" + fillName);

//				生成訂單
			makeOrderOK = ordersrvc.add(orderList.get(i));

			if (makeOrderOK == 1) {
//					System.out.println("本次採購，第"+i+1+"張訂單，生成完畢。");
//					儲存 採購成功的 訂單 到request域
				if (memberId == orderList.get(i).getMember_id()) {
					finalOrderList.add(ordersrvc.findLatestByMemId(memberId));
//						System.out.println("已經儲存最新一筆採購成功的訂單資料到結帳清單");
				}

//					移除購物車對應項目
				for (int j = 0; j < orderList.get(i).getOrderDesBOList().size(); j++) {
					cartProDesId = orderList.get(i).getOrderDesBOList().get(j).getProdes_id();
					cart.removeCartItem(cart, cartProDesId);
//						System.out.println("購物車 移除商品編號："+cartProDesId);
				}
			}

			makeOrderOK = 0;
		}

//		更新購物車session
		session.setAttribute("cart", cart);
//		顯示在畫面上(需要店家名稱，訂單編號)
		request.setAttribute("finalOrderList", finalOrderList);
		request.getRequestDispatcher("shop/goods_payment_complete.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}

}
