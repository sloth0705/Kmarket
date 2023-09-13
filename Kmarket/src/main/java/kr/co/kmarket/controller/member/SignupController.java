package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.MemberTermsDTO;
import kr.co.kmarket.service.MemberTermsService;

@WebServlet("/member/signup.do")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = -722360530067949982L;
	private MemberTermsService service = MemberTermsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		MemberTermsDTO dto = service.selectMemberTerms();
		
		req.setAttribute("type", type);
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/signup.jsp");
		dispatcher.forward(req, resp);
	}
}
