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
//,DispatcherType.FORWARD
//@WebFilter(value = {"/shop/goods_index.jsp"}, dispatcherTypes = DispatcherType.REQUEST)
public class Filter3IndexRequest extends HttpFilter {

	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)	throws IOException, ServletException {

//		為了獲取框架Hibernate做的service，需先取得一個ServletContext物件....
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ProductServiceHibernate service = context.getBean(ProductServiceHibernate.class);
//		取得最新商品資料
		List<ProductBO> latest10 =  (List<ProductBO>) service.findNew();
		application.setAttribute("latest10", latest10);

//		取得熱門商品資料
		ShopService shopsvc = new ShopServiceImpl();
		List<ProductBO> popular10 = shopsvc.findPopularNum(10);
		application.setAttribute("popular10",popular10);   
		
		System.out.println("Filter3indexRequest執行了");
		super.doFilter(request, response, chain);
		System.out.println("Filter3indexRequest回來了");
	}
	
    public Filter3IndexRequest() {
    }

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
