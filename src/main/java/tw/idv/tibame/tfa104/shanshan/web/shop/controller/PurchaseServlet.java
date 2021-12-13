package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import tw.idv.tibame.tfa104.shanshan.web.member.service.MemberService;
import tw.idv.tibame.tfa104.shanshan.web.member.service.impl.MemberServiceImpl;
import tw.idv.tibame.tfa104.shanshan.web.order.entity.Order;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescription;
import tw.idv.tibame.tfa104.shanshan.web.orderDescription.entity.OrderDescriptionBO;
import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.product.service.ProductServiceHibernate;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.Cart;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.CartItem;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ShopService service = new ShopServiceImpl();
		String method = "";
		int prodesId = 0;
		int itemQTY = 0;  
		int memberPoint = 0;
		
//		取得會員ID
		int memberId = 0;  
		HttpSession session = request.getSession();
		if (session.getAttribute("memberId") != null) {
			memberId = (int) session.getAttribute("memberId");
		}

//		取得會員點數
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService memsrvc = context.getBean(MemberServiceImpl.class);
		memberPoint = memsrvc.findMemberPoints(memberId);
		request.setAttribute("memberPoint", memberPoint);
		
//		確認是否有結帳資料(orderList)在session，沒有的話就新建一個，有的話就清除。
		List<Order> orderList = (List<Order>) session.getAttribute("orderList");
		if (orderList == null) {
			orderList = new ArrayList<Order>(); //訂單 集合
		}else {
			orderList.clear();
		}

		
//		取得session中的cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
//		確認結帳方法
		if(request.getParameter("method") != null) {
		method = request.getParameter("method"); 
		}else {
//			如果method為空，回到首頁
			response.sendRedirect(request.getContextPath()+"/shop/goods_index.jsp");
		};

		
//		直接購買  url參數：http://localhost:8081/shanshan/PurchaseServlet?method=buyDirectly&productDesId=43&itemQTY=1
		if ("buyDirectly".equals(method)) {
			if(request.getParameter("productDesId") != null) {
				prodesId = Integer.parseInt(request.getParameter("productDesId")); 
			}else {
//				如果productDesId為空，回到首頁
				response.sendRedirect(request.getContextPath()+"/shop/goods_index.jsp");
			};

			if(request.getParameter("itemQTY") != null) {
				itemQTY = Integer.parseInt(request.getParameter("itemQTY"));
			}else {
//				如果itemQTY為空，回到首頁
				response.sendRedirect(request.getContextPath()+"/shop/goods_index.jsp");
			};
//			===把本商品加到購物車 (copy code from CartServlet)====
// 			取得cartItem物件map集合
			Map<String, CartItem> mapCartItem = cart.getMapCartItem();

//			把productDesId轉成字串
			String productDesIdStr = Integer.toString(prodesId);
//			如果目前購物車沒這productDesId
			if (mapCartItem.get(productDesIdStr) == null) {
//			 調用方法，在cart，新增CartItem
			cart.addCartItem(cart, prodesId, itemQTY);
// 			改變購物車icon的數字
			cart.setTotalItemQTY(cart.getTotalItemQTY());
// 			放新購物車到session
			request.getSession().setAttribute("cart", cart);
			}
			else {
//			如果目前購物車有這productDesId，方法改變回變更數量
			cart.changeItemQTY(cart, prodesId, itemQTY);
			}

//			===================
//			生成訂單
				Order order = new Order();
//			賦予 各訂單 店家ID
				order.setCompany_id(mapCartItem.get(productDesIdStr).getCompanyId());
//				System.out.println("新的訂單產生了，本訂單屬於店家編號："+mapCartItem.get(productDesIdStr).getCompanyId());
//			設定 各訂單的資料，避免之後的空指針問題
				order.setOrder_sum_after(0);
				order.setOrder_sum_before(0);
				order.setOrder_status(0);
				order.setPayment_status(0);
				order.setPoint_used(0);
				order.setMember_id(memberId);
//			把這張訂單，放進訂單集合
				orderList.add(order);
			
//			System.out.println("======所有訂單生成完畢========");
//			取出對應的商品資料
				ProductBO productBO = service.findProductByProDesId(prodesId);
//				System.out.println("按照prodesId："+prodesId+"，取出的productBO資料為："+productBO.getProductName());
//			做成訂單明細
				OrderDescriptionBO OrderDesBO = new OrderDescriptionBO();
				OrderDesBO.setCompany_id(productBO.getCompanyId());
				OrderDesBO.setCompany_name(productBO.getCompanyName());
				OrderDesBO.setProduct_color(productBO.getProductColor());
				OrderDesBO.setProduct_size(productBO.getProductSize());
				OrderDesBO.setProdes_id(productBO.getProdesId());
				OrderDesBO.setProduct_id(productBO.getProductId());
				OrderDesBO.setProduct_name(productBO.getProductName());
				OrderDesBO.setProduct_quantity(itemQTY);
				OrderDesBO.setOrder_description_price(productBO.getProductPrice());
				OrderDesBO.setSubtotal_price(itemQTY*productBO.getProductPrice());
//				System.out.println("一張訂單OrderDesBO，產生了，他的品名/單價/數量/小計為"+ OrderDesBO.getProduct_name() + "/"+ OrderDesBO.getOrder_description_price() + "/"+ OrderDesBO.getProduct_quantity() + "/"+ OrderDesBO.getSubtotal_price() );
//				把訂單明細加入訂單
				orderList.get(0).getOrderDesBOList().add(OrderDesBO);
//				把訂單明細加入訂單後，需要更新訂單的總價錢
				orderList.get(0).setOrder_sum_before(orderList.get(0).getOrder_sum_before()+OrderDesBO.getSubtotal_price());
			
		};

//		從購物車購買   url參數：http://localhost:8081/shanshan/PurchaseServlet?method=buyCart &1=63 &2=43 &3=41 &4=21
		if ("buyCart".equals(method)) {
			int MaxQTY = 20; 	 // 購物車項目最大數量
			int count = 1;  	 // 商品迴圈計數器
			int sum = 0;		 //全部採購的數量
			Map<String, Integer> companyIdMap = new HashMap<String, Integer>();

			List<OrderDescription> ItemProDesIdList = new ArrayList<OrderDescription>();  //本次採購的ProDesId LIST	
			
			for  (count = 1 ; count <= MaxQTY ; count++) {
				if(request.getParameter(count+"") != null){
//					取得本次採購的ProDesId LIST
					OrderDescription oderDes = new OrderDescription();
					oderDes.setProduct_des_id(Integer.parseInt(request.getParameter(count+"")));
					ItemProDesIdList.add(oderDes);
//					System.out.println("商品明細編號"+ItemProDesIdList.get(count-1).getProduct_des_id()+"加入了結帳列表");
//					用ProDesId取出session購物車的購物車項目
					CartItem cartItem = cart.getMapCartItem().get(ItemProDesIdList.get(count-1).getProduct_des_id()+"");
//					System.out.println("購物車項目 依照Product_des_id被選了出來： "+cartItem);
//					把購物車項目 product des id 對應的 itemQTY 存進去ItemProDesIdList
					ItemProDesIdList.get(count-1).setProduct_quantity(cartItem.getItemQTY()); 
//					System.out.println("ItemProDesIdList列表的第"+(count)+"項，商品編號："+ItemProDesIdList.get(count-1).getProduct_des_id()+"，加入了數量屬性： "+ItemProDesIdList.get(count-1).getProduct_quantity());
//					用map集合 檢查有多少本次採購 有多少店家的訂單 檢查有多少店家
					companyIdMap.put(cartItem.getCompanyId()+"",0);
//					取得商品總數
					sum += 1;
//					System.out.println("目前在循環中，ItemProDesIdList第"+(count)+"項，商品編號為"+ItemProDesIdList.get(count-1).getProduct_des_id());
				}
			}
//			System.out.println("===============================");
//			System.out.println("******警告*******ItemProDesIdList資料為："+ItemProDesIdList);
//			System.out.println("本次採購總共包含"+companyIdMap.size()+"間店家的商品");
//			把MAP集合轉變成list集合
			List<String> companyIdList = new ArrayList<String>(companyIdMap.keySet());
//			取得店家總數，即為需要生成的訂單總數
			int orderQTY = companyIdList.size();
//			System.out.println("本次採購產生了"+orderQTY+"張訂單");
			
//			System.out.println("===============================");
//			生成訂單
			for (count = 0; count < orderQTY; count++) {
				Order order = new Order();
//			賦予 各訂單 店家ID
				order.setCompany_id(Integer.parseInt(companyIdList.get(count)));
//				System.out.println("新的訂單產生了，本訂單屬於店家編號："+order.getCompany_id());
//			設定 各訂單的資料，避免之後的空指針問題
				order.setOrder_sum_after(0);
				order.setOrder_sum_before(0);
				order.setOrder_status(0);
				order.setPayment_status(0);
				order.setPoint_used(0);
				order.setMember_id(memberId);
//			把這張訂單，放進訂單集合
				orderList.add(order);
//				System.out.println("放了一張新的訂單到orderList，本訂單屬於店家編號為："+orderList.get(count).getCompany_id());
			}
			
//			System.out.println("================所有訂單生成完畢=====================");
//			遍歷所有採購的ProDesId
			for (int i = 0; i < sum; i++) {
				prodesId = ItemProDesIdList.get(i).getProduct_des_id();
//				System.out.println("從ItemProDesIdList集合第"+(i+1)+"項，取出的prodesId為："+prodesId);
//			取出對應的商品資料
				ProductBO productBO = service.findProductByProDesId(prodesId);
//				System.out.println("按照prodesId："+prodesId+"，取出的productBO資料為："+productBO.getProductName());
//			做成訂單明細
				OrderDescriptionBO OrderDesBO = new OrderDescriptionBO();
				OrderDesBO.setCompany_id(productBO.getCompanyId());
				OrderDesBO.setCompany_name(productBO.getCompanyName());
				OrderDesBO.setProduct_color(productBO.getProductColor());
				OrderDesBO.setProduct_size(productBO.getProductSize());
				OrderDesBO.setProdes_id(productBO.getProdesId());
				OrderDesBO.setProduct_id(productBO.getProductId());
				OrderDesBO.setProduct_name(productBO.getProductName());
				OrderDesBO.setProduct_quantity(ItemProDesIdList.get(i).getProduct_quantity());
				OrderDesBO.setOrder_description_price(productBO.getProductPrice());
				OrderDesBO.setSubtotal_price(ItemProDesIdList.get(i).getProduct_quantity()*productBO.getProductPrice());
//				System.out.println("一張訂單OrderDesBO，產生了，他的品名/單價/數量/小計為"+ OrderDesBO.getProduct_name() + "/"+ OrderDesBO.getOrder_description_price() + "/"+ OrderDesBO.getProduct_quantity() + "/"+ OrderDesBO.getSubtotal_price() );
//			遍歷所有的訂單跟他的店家ID，如果訂單明細的店家ID跟訂單的店家ID一樣，就把訂單明細塞進去這張訂單
				for (int j = 0; j < orderList.size(); j++) {
					if (OrderDesBO.getCompany_id() == orderList.get(j).getCompany_id()) {
//						System.out.println("訂單明細："+OrderDesBO.getProduct_name()+"因為店家ID和訂單相同,因此歸類到第"+ (i+1) +"張訂單下(店家ID" +OrderDesBO.getCompany_id() +"==" + orderList.get(j).getCompany_id()+ ")");
						orderList.get(j).getOrderDesBOList().add(OrderDesBO);
//						把訂單明細加入訂單，需要更新訂單的總價錢
						orderList.get(j).setOrder_sum_before(orderList.get(j).getOrder_sum_before()+OrderDesBO.getSubtotal_price());
					}
				}
			}
//			System.out.println("===============================");
//			System.out.println("結束訂單明細歸類，目前訂單集合資料為："+orderList);

			
		}

//		如果真的結帳，資料會重複用到，所以把資料存到Session
			request.getSession().setAttribute("orderList", orderList);
			request.getRequestDispatcher("/shop/goods_payment_check.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doGet(request, response);
	}
}


