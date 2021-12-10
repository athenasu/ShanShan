package tw.idv.tibame.tfa104.shanshan.web.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.idv.tibame.tfa104.shanshan.web.company.entity.CompanyVO;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.ShopService;
import tw.idv.tibame.tfa104.shanshan.web.shop.service.impl.ShopServiceImpl;

@WebServlet("/GetCompanyBannerServlet")
public class GetCompanyBannerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//來源路徑<%=contextPath %>/GetComapnytServlet?comapnyId=${comapnyBO.comapnyId}
		
		int company_id = Integer.parseInt(request.getParameter("companyId"));

//		根據company_id 顯示company banner
		String action = request.getParameter("action");
		if ("companyBanner".equals(action)) {
			ServletOutputStream out = response.getOutputStream();

			ShopService service = new ShopServiceImpl();
			CompanyVO companyDetail = service.findCompanyByComId(company_id);

			try {
			byte[] companyBanner = null;
			companyBanner = companyDetail.getCompanyBanner();
			out.write(companyBanner);
			out.flush();
			} catch (Exception e) {
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


