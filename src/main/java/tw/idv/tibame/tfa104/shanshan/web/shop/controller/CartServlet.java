package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.CartItem;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {

		ShopService service = new ShopServiceImpl();
		String method ="";
		Integer productDesId = 0;
		Integer itemQTY = 0;
		
		// 獲取調用方法
		if(request.getParameter("method") != null) {
			method = request.getParameter("method");
		}
		
//		System.out.println("CartServlet被調用了,method :" + method);

		// 來源路徑<%=request.getContextPath()%>/CartServlet?method=mycart
		// 一般進入購物車
		if ("mycart".equals(method)) {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			response.sendRedirect("shop/goods_shopcart.jsp");
		}
		
		// 新增購物車項目 // 來源路徑<%=contextPath // /CartServlet?method=addCartItem&productDesId=${????/}&itemQTY=${?????}
		if ("addCartItem".equals(method)) {
			// 調用方法，獲取現有購物車
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 取得商品明細編號
			productDesId = Integer.parseInt(request.getParameter("productDesId"));
			// 取得數量
			itemQTY = Integer.parseInt(request.getParameter("itemQTY"));
			// 取得cartItem物件map集合
			Map<String, CartItem> mapCartItem = cart.getMapCartItem();

//			把productDesId轉成字串
			String productDesIdStr = Integer.toString(productDesId);
//			如果目前購物車沒這productDesId
			if (mapCartItem.get(productDesIdStr) == null) {
			// 調用方法，在cart，新增CartItem
			cart.addCartItem(cart, productDesId, itemQTY);
			// 改變購物車icon的數字
			cart.setTotalItemQTY(cart.getTotalItemQTY());
			// 放新購物車到session
			request.getSession().setAttribute("cart", cart);

			// 取得商品明細編號對應的商品編號
			ProductBO productBO = service.findProductByProDesId(productDesId);
			Integer productId = productBO.getProductId();

			// 重新定向，到原來商品頁面
			response.sendRedirect("/GetProductServlet?productId=" + productId);
			}else {
//			如果目前購物車有這productDesId，方法改變回變更數量
			cart.changeItemQTY(cart, productDesId, itemQTY);
			}
		}
		
		// 刪除購物車項目 // 來源路徑<%=contextPath	// /CartServlet?method=removeCartItem&productDesId=${????/}
		if ("removeCartItem".equals(method)) {
			// 調用方法，獲取現有購物車
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 取得商品明細編號
			productDesId = Integer.parseInt(request.getParameter("productDesId"));
			// 調用方法，刪除購物車項目
			cart.removeCartItem(cart, productDesId);
		//  改變購物車icon的數字
			cart.setTotalItemQTY(cart.getTotalItemQTY());
			// 放新購物車到session
			request.getSession().setAttribute("cart", cart);
		}

		// 清空購物車 // 來源路徑<%=contextPath	// /CartServlet?method=cleanCartItem&productDesId=${????/}
		if ("cleanCartItem".equals(method)) {
			// 調用方法，獲取現有購物車
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 調用方法，清空cart
			cart.cleanCartItem(cart);
		//  改變購物車icon的數字
			cart.setTotalItemQTY(cart.getTotalItemQTY());
			// 放新購物車到session
			request.getSession().setAttribute("cart", cart);
		}

		// 更改購物車項目數量 // 來源路徑<%=contextPath	// /CartServlet?method=changeItemQTY&productDesId=${????/}&itemQTY=${?????}
		if ("changeItemQTY".equals(method)) {
			// 取得商品明細編號
			productDesId = Integer.parseInt(request.getParameter("productDesId"));
			// 取得數量
			itemQTY = Integer.parseInt(request.getParameter("itemQTY"));
			// 調用方法，獲取現有購物車
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 調用方法，改變項目數量
			cart.changeItemQTY(cart, productDesId, itemQTY);
			// 放新購物車到session
			request.getSession().setAttribute("cart", cart);
		}
		
		
		// 輸出CartItemQty的數字    // 來源路徑<%=contextPath	// /CartServlet?method=showCartItemQty
		if ("showCartItemQty".equals(method)) {
//			System.out.println("CartServlet?method=showCartItemQty執行了");
			// 調用方法，獲取現有購物車
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			// 調用方法，得到目前的TotalItemQTY
			int sum = cart.getTotalItemQTY();
			// 輸出到頁面上
			response.getWriter().print(sum);
			response.getWriter().flush();
			response.getWriter().close();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}
	
}
