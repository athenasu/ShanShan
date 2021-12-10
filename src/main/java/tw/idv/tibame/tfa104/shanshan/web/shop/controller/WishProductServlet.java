package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mysql.cj.Session;

import tw.idv.tibame.tfa104.shanshan.web.member.entity.Member;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service.WishlistProductService;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.service.impl.WishlistProductServiceImpl;

@WebServlet("/WishProductServlet")
public class WishProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws IOException, ServletException {
		
		String method = request.getParameter("method");
		int productId = Integer.parseInt(request.getParameter("productId"));
		Map mapwp = new HashMap();
		
		System.out.println("WishListServlet被調用了,method :" + method);

//		取得session
		HttpSession session = request.getSession();
//		取得會員ID
		if(session.getAttribute("memberId") != null) {
			int memberId = (int) session.getAttribute("memberId");

			// 來源路徑 /shanshan/WishProductServlet?method=addRemoveWishProduct&productId=??
			if ("addRemoveWishProduct".equals(method)) {
				mapwp = (Map) session.getAttribute("mapwp");
				
				ServletContext application = this.getServletContext();
				WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
				WishlistProductService wpsrc = context.getBean(WishlistProductServiceImpl.class);
				
//				如果有收藏裡有這件產品
				if(mapwp.containsKey(productId)) {
//					true, 移除收藏
					wpsrc.deleteWishlistProductMemIdProductId(memberId,  productId);
					
					System.out.println("WishProductServlet: 移除收藏成功");
//					把該KEY從收藏列表中移除
					mapwp.remove(productId);

				}
				else {
//					false，加入收藏
					WishlistProduct wp = new WishlistProduct();
					wp.setProductId(productId);
					wp.setMemberId(memberId);
					wpsrc.addWishlistProduct(wp);
					
					System.out.println("WishProductServlet: 添加收藏成功");
//					把該KEY加入收藏列表
					mapwp.put(productId, memberId);
				};

//				把新的收藏列表丟進session
				session.setAttribute("mapwp", mapwp);
				System.out.println("WishProductServlet: 更新收藏");

			}

			
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doPost(request, response);
	}
}



//跳轉到JSP
//request.getRequestDispatcher("shop/goods_product_page.jsp").forward(request, response);


//// 輸出CartItemQty的數字    // 來源路徑<%=contextPath	// /CartServlet?method=showCartItemQty
//if ("showCartItemQty".equals(method)) {
//System.out.println("CartServlet?method=showCartItemQty執行了");
//// 調用方法，獲取現有購物車
//Cart cart = getCart(request);
//// 調用方法，得到目前的TotalItemQTY
//int sum = cart.getTotalItemQTY();
//// 輸出到頁面上
//response.getWriter().print(sum);
//response.getWriter().flush();
//response.getWriter().close();
//}
