package tw.idv.tibame.tfa104.shanshan.web.cabin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import tw.idv.tibame.tfa104.shanshan.web.cabin.service.impl.MtnForCabinService;
import tw.idv.tibame.tfa104.shanshan.web.event.service.EventService;
import tw.idv.tibame.tfa104.shanshan.web.mountain.entity.Mountain;
import tw.idv.tibame.tfa104.shanshan.web.mountain.service.MountainService;

@WebServlet("/CabinServlet.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)


public class CabinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CabinServlet() {
		super();
	}

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();

		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		MountainService mtnSvc = context.getBean(MountainService.class);
		application.setAttribute("mtnSvc", mtnSvc);
		
		EventService eventSvc = context.getBean(EventService.class);
		application.setAttribute("eventSvc", eventSvc);
		
		MtnForCabinService mtnForCabinSvc = new MtnForCabinService();
		application.setAttribute("mtnForCabinSvc", mtnForCabinSvc);
		
		
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String action = req.getParameter("action");
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MountainService mtnSvc = context.getBean(MountainService.class);
		Mountain mtn = new Mountain();

//		============================================
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "101@九九山莊@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=68");
		map.put("2", "111@九九山莊@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=68");
		map.put("3", "114@桃山山屋@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=58");
		map.put("4", "126@無@無");
		map.put("5", "141@無@無");
		map.put("6", "102@翠池山屋@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=17");
		map.put("7", "2@南湖山屋@https://npm.cpami.gov.tw/bed_4.aspx?orgid=105e956f-d8da-49f7-a9b7-3aefdda88a12&node_id=152");
		map.put("8", "9@油婆蘭營地@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=392");
		map.put("9", "0@無@無");
		map.put("10", "8@桃山山屋@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=58");
		map.put("11", "57@三叉營地@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=410");
		map.put("12", "61@天池山莊@https://tconline.forest.gov.tw/room");
		//天池山莊要另外抓class 
		map.put("13", "76@無@無");
		map.put("14", "50@三叉營地@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=410");
		map.put("15", "60@三叉營地@https://npm.cpami.gov.tw/bed_1.aspx?orgid=e6dd4652-2d37-4346-8f5d-6e538353e0c2&node_id=410");
		map.put("16", "19@南湖山屋@https://npm.cpami.gov.tw/bed_4.aspx?orgid=105e956f-d8da-49f7-a9b7-3aefdda88a12&node_id=152");
		map.put("17", "32@成功山屋@https://npm.cpami.gov.tw/bed_4.aspx?orgid=105e956f-d8da-49f7-a9b7-3aefdda88a12&node_id=125");
		map.put("18", "54@無@無");
		map.put("19", "78@無@無");
		map.put("20", "28@成功山屋@https://npm.cpami.gov.tw/bed_4.aspx?orgid=105e956f-d8da-49f7-a9b7-3aefdda88a12&node_id=125");
		

//		=============================================
	
		if ("getBooking".equals(action)) {
			
			String mtnId =req.getParameter("mountainId");
			PrintWriter out = res.getWriter();								
			try {
				if("21".equals(mtnId)|"22".equals(mtnId)|"23".equals(mtnId)|"24".equals(mtnId)) {
					out.write("<h3 style=\"text-align:center;color:#318d2b\">目前未提供山屋預約或不需申請</h3>");
					out.flush();
				}else {
					String cabinName = map.get(mtnId).split("@")[1];			
					String cabinweb = map.get(mtnId).split("@")[2];
					
					if("12".equals(mtnId)) {
						String middleURL = cabinweb;
						HashMap<String, String> cookies = new HashMap<>();
						Document doc = Jsoup.connect(middleURL).cookies(cookies).get();
						if (doc != null) {
								Elements elements = doc.select(".calendar_table");
								for (Element e : elements) {
									e.select("a").remove();
									e.select("img").remove();
									String str = "<div>"+cabinName+"</div>";
									out.write(str+"<table>"+e.html()+"</table>");
									out.flush();
								}
						}
					}else if("無".equals(cabinName)) {
						out.write("<h3 style=\"text-align:center;color:#318d2b\">目前未提供山屋預約或不需申請</h3>");
					}else {
						String middleURL = cabinweb;
						HashMap<String, String> cookies = new HashMap<>();
						Document doc = Jsoup.connect(middleURL).cookies(cookies).get();
						if (doc != null) {
								Elements elements = doc.select(".DATA");
								for (Element e : elements) {
									e.select("a").removeAttr("href").removeAttr("title");
									String str = "<div>"+cabinName+"</div>";
									out.write(str+"<table>"+e.html()+"</table>");
									out.flush();
								}
						}
					}
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				out.close();
			}
			
		}
		if("getMtnImg".equals(action)) {
			res.setContentType("image/gif");
			ServletOutputStream out = res.getOutputStream();
			try {
				int mountainId =  Integer.parseInt(req.getParameter("mountainId"));

				mtn = mtnSvc.findMtnByPk(mountainId);
				byte[] pic = null;
				pic = mtn.getMountainPic();
				
				out.write(pic);
				out.flush();

			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}
		if("getMtn".equals(action)) {
			
			try {
				int mountainId =  Integer.parseInt(req.getParameter("mountainId"));
				mtn = mtnSvc.findMtnByPk(mountainId);
				req.setAttribute("mtn", mtn);

				String url = "/cabin/mtnCabin.jsp";
				RequestDispatcher view = req.getRequestDispatcher(url);
				view.forward(req, res);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if("getnum".equals(action)) {		
			String mtnId =  req.getParameter("mountainId");
			PrintWriter out = res.getWriter();
			String weatherId;

			try {
				if("21".equals(mtnId)|"22".equals(mtnId)|"23".equals(mtnId)|"24".equals(mtnId)) {
					weatherId = "none";
				}
				else {
					weatherId = map.get(mtnId).split("@")[0];
				}
				out.write(weatherId);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				out.close();
			}
		}
		
	}
	

}
