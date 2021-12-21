package tw.idv.tibame.tfa104.shanshan.web.article.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckAccount.do")
public class CheckAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


    public CheckAccount() {
        super();
    }
    


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		try {
			if(session.getAttribute("memberId") != null) {
				out.write("ok");
			}else {
				out.write("NG");
			}
		}catch(Exception e) {
				e.printStackTrace();
			
		}finally {
			out.close();
		}

	}

}
