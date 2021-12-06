package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.product.entity.ProductBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//來源路徑<%=contextPath %>/GetProductServlet?productId=${ProductBO.productId}

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");


		int product_id = 0;
		product_id = Integer.parseInt(request.getParameter("productId")); //取得對應product_id
		
		ShopService service = new ShopServiceImpl();
		List<ProductBO> listProductDetail = service.findProductByProId(product_id); //取得對應product_id的資料
		
		
//		顯示商品細節區域
		if (product_id != 0) {

		request.setAttribute("listProductDetail", listProductDetail);
		
		}
//		取出樣式
//		建立 新集合 存放樣式
		List<String> listStyle = new ArrayList<String>();
		if (listProductDetail != null) {
			for ( int i = 0 ; i < listProductDetail.size() ; i ++) {
//				取出list物件集合中的productBO物件
				ProductBO productBO = listProductDetail.get(i);
//				把該productBO物件的顏色字串拿出來
//				把樣式字串放進去新集合
				int size = productBO.getProductSize();
				String strSize = null;
				switch (size) {
				case 0:
					strSize = "標準";
					break;
				case 1:
					strSize = "S";
					break;
				case 2:
					strSize = "M";
					break;
				case 3:
					strSize = "L";
					break;
				case 4:
					strSize = "XL";
					break;
				}
				listStyle.add(productBO.getProductColor() + "&ensp;/&ensp;" + strSize);
			}
//			System.out.println(listStyle);
		}
//		傳值 樣式
		request.setAttribute("listStyle", listStyle);

//		顯示麵包屑 中文 商品種類
		ProductBO productDetail = new ProductBO();
		productDetail = listProductDetail.get(0);
		int PorductType = productDetail.getProductType();
		String porductTypeName = null;
		
		if (PorductType == 1) {
			porductTypeName ="衣著/鞋子/背包"; 
		}else if (PorductType == 2){
			porductTypeName ="工具/照明/登山杖"; 
		}else if (PorductType == 3){
			porductTypeName ="炊具"; 
		}else if (PorductType == 4){
			porductTypeName ="寢具/帳篷/睡袋"; 
		}
//		傳值 商品種類 到JSP
		request.setAttribute("porductTypeName", porductTypeName);
		
		
//		取出全部圖片物件，傳到JSP 讓JSP拿對應次數的product_ID
		List<ProductImgBO> listAllPic = new ArrayList<ProductImgBO>();
		listAllPic = service.getAllProPic(product_id);
		
		request.setAttribute("listAllPic", listAllPic );
		
//		其他熱門商品區域
		List<ProductBO> popular5 = service.findPopularNum(5);
		request.setAttribute("popular5",popular5);   

//		跳轉到JSP
		request.getRequestDispatcher("shop/goods_product_page.jsp").forward(request, response);
	}



protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	this.doPost(request, response);
}
}


