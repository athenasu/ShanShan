package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tw.idv.tibame.tfa104.shanshan.web.productImg.entity.ProductImgBO;
import tw.idv.tibame.tfa104.shanshan.web.productImg.service.impl.ProductImgBOService;
import tw.idv.tibame.tfa104.shanshan.web.productImg.service.impl.ProductImgBOServiceImpl;

@WebServlet("/ProductPicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ProductPicServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//來源跳轉路徑"<%=contextPath%>/ProductPicServlet?productId=${ProductBO.productId}&action=getPopImage"

		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if ("getPopImage".equals(action)) {
			response.setContentType("image/gif");
			ServletOutputStream out = response.getOutputStream();

			try {
				int product_id = Integer.parseInt(request.getParameter("productId"));
				ProductImgBOService odsvc = new ProductImgBOServiceImpl(); 
				ProductImgBO productBO =new ProductImgBO();
				productBO = odsvc.getProDesFirstPic(product_id);
				byte[] popPic = null;
				popPic = productBO.getProduct_first_pic();
				out.write(popPic);
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


