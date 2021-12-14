package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.shop.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/ProductPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProductPicServlet extends HttpServlet {
	private static final long serialVersionUID = -1212325068431259995L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
//		輸出I/O流預備
		ServletOutputStream out = response.getOutputStream();

//		準備相關物件變數參數
		ShopService shopsvc = new ShopServiceImpl(); 
		ProductImgBO productImgBO =new ProductImgBO();
//		List<ProductImgBO> listproductImgBO =new ArrayList<ProductImgBO>();
		byte[] pic = null;
		
		
		int productId = 0;
		int productSequence = 0;
		String action ="";

		if (request.getParameter("action")!= null) {
			action = request.getParameter("action");
		}

		if (request.getParameter("productId") != null) {
			productId = Integer.parseInt(request.getParameter("productId"));
		}
		
//		來源跳轉路徑"<%=contextPath%>/ProductPicServlet?productId=${ProductBO.productId}&productSequence=0&action=firstPic"
//		輸出第一張圖片
		if ("firstPic".equals(action)) {

			try {
				productImgBO = shopsvc.getProDesFirstPic(productId);
				pic = productImgBO.getProduct_first_pic();
				out.write(pic);
				out.flush();
			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			
		}

//		來源跳轉路徑"<%=contextPath%>/ProductPicServlet?productId=${ProductBO.productId}&productSequence=${ProductBO.productImgId}&action=thePic"
//		按照productId的第?張圖片輸出圖片
		if ("thePic".equals(action)) {

			if (request.getParameter("productSequence") != null) {
				productSequence = Integer.parseInt(request.getParameter("productSequence"));
			}
			
			try {
				productImgBO = shopsvc.getPic(productId,productSequence);
				pic = productImgBO.getProduct_the_pic();
				out.write(pic);
				out.flush();
			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
			
			
		}
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


