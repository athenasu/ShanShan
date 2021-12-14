package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/AllCompanyServlet")
public class AllCompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


			ShopService service = new ShopServiceImpl();
			List<CompanyVO> listAllCompanyVO = service.findAllCompany();

			request.setAttribute("listAllCompanyVO", listAllCompanyVO);
			request.getRequestDispatcher("/shop/goods_store_list.jsp").forward(request, response);
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doPost(request, response);
	}
}


