package tw.idv.tibame.tfa104.shanshan.web.shop.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.wishlistProduct.entity.WishlistProduct;
//@WebFilter(value = {"/shop/goods_product_page.jsp"}, dispatcherTypes = DispatcherType.FORWARD)
public class Filter4ProductForward extends HttpFilter {

	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

//		取得熱門商品資料
		ShopService shopsvc = new ShopServiceImpl();
		List<ProductBO> popular10 = shopsvc.findPopularNum(10);
		request.setAttribute("popular10",popular10);
		
		
		System.out.println("Filter4ProductForward執行了");
		super.doFilter(request, response, chain);
		System.out.println("Filter4ProductForward回來了");
	}
	
    public Filter4ProductForward() {
    }

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
