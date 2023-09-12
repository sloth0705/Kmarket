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

@WebServlet("/member/checkCompany.do")
public class CheckCompanyController extends HttpServlet {
	private static final long serialVersionUID = 285127245916269930L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// private MemberService
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String company = req.getParameter("company");
		logger.debug("company : " + company);
		
		int result = 0; // service.selectCountcompany(company)
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);

		// JSON 출력
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}
