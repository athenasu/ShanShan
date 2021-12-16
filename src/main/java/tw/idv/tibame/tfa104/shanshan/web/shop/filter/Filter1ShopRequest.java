package tw.idv.tibame.tfa104.shanshan.web.shop.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
@WebFilter(value = {"/shop/goods_index.jsp","/shop/goods_shopcart.jsp"}, dispatcherTypes = DispatcherType.REQUEST)
public class Filter1ShopRequest extends HttpFilter {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)	throws IOException, ServletException {

		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
//		取得session
		HttpSession session = request.getSession();
		
//		購物車
//		取得購物車資訊，如果沒有購物車在session，就生成一個空購物車
		Cart cart = (Cart) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		

//		登入設定
		Object memberIdOB = null ;
		int memberId = 0;
		Map<String,Integer> mapwp = new HashMap<String,Integer>();
//		如果已經登入
//		if (session.getAttribute("memberId") != null || session.getAttribute("memberId") != "") {
//		取得session的memberId
		memberIdOB = session.getAttribute("memberId");

//		如果已經登入
		if(memberIdOB != null) {
//			取得登入會員ID
			memberId = (int) memberIdOB;
			System.out.println("已經登入了喔");
//			收藏功能
//			得到該會員所有收藏物件
			ShopService service = new ShopServiceImpl();
			List<WishlistProduct> Listwp = service.getWishlistProductsByMemberId(memberId);
//			System.out.println("memberId :"+ memberId+"的收藏為 : "+ Listwp);
//			把ProductId作為KEY，存放WishlistProduct物件在MAP集合
			for (int i = 0 ; i < Listwp.size() ; i++) {
				WishlistProduct wp = Listwp.get(i);
				mapwp.put(wp.getProductId()+"", memberId);
			}
//			System.out.println("memberId :"+ memberId+"的收藏為 : "+ mapwp);
			
//			存放mapwp到session;
			session.setAttribute("mapwp", mapwp);
			
//			把收藏map轉成list存放  只存放商品編號，用於在JSP上取值
			List<String> listwpProductId = new ArrayList<String>(mapwp.keySet());
			session.setAttribute("listwp", listwpProductId);
		}
//		如果沒有登入
		else if (memberId == 0) {
////				假登入，讓memeber_id 1號登入
//				memberId = 1;
//				session.setAttribute("memberId", memberId);   
//				System.out.println("假登入被執行了，memberId:"+ memberId);
			
//				存放一個member_Id=0，作為未登入使用者
//				session.setAttribute("memberId", memberId);  
			System.out.println("沒有登入喔");
			}

		System.out.println("Filter1Shop執行了");
		super.doFilter(request, response, chain);
		System.out.println("Filter1Shop回來了");
	}
	
    public Filter1ShopRequest() {
    }

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
