package kr.co.kmarket.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

@WebServlet("/member/checkFax.do")
public class CheckFaxController extends HttpServlet {
	private static final long serialVersionUID = -1917829729621921757L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// private MemberService
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fax = req.getParameter("fax");
		logger.debug("fax : " + fax);
		
		int result = 0; // service.selectCountfax(fax)
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		// JSON 출력
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}
