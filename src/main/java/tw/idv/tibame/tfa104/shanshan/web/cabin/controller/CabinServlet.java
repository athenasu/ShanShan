package tw.idv.tibame.tfa104.shanshan.web.cabin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@WebServlet("/CabinServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)

public class CabinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CabinServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");
		
		if ("getBooking".equals(action)) {
			PrintWriter out = res.getWriter();
			String middleURL = "https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=304";
			HashMap<String, String> cookies = new HashMap<>();
			Document doc = Jsoup.connect(middleURL).cookies(cookies).get();
			if (doc != null) {
				// 中霸山屋
				Document doc3 = Jsoup.connect(middleURL).cookies(cookies).get();
				
				if (doc3 != null) {
					Elements elements = doc3.select(".DATA");
					for (Element e : elements) {
						e.select("a").removeAttr("href");
						out.write(e.html());
					}
				}
			}
		}
	}

}
