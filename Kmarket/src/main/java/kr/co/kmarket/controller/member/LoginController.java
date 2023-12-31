package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = -2365079189659779648L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid  = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String autoChk = req.getParameter("auto");
		
		MemberDTO member = service.selectMember(uid, pass); // 사용자가 존재하지 않으면 null
		
		if (member != null)
		{
			HttpSession session = req.getSession();
			session.setAttribute("sessMember", member);
			
			// 로그인 유지처리
			if (autoChk != null) // 자동로그인 체크
			{
				Cookie cookie = new Cookie("memberCookie", member.getUid());
				cookie.setMaxAge(60*60*24*7);
				cookie.setPath("/");
				resp.addCookie(cookie);
			}
			
			logger.info("sessMember level : " + member.getLevel());
			resp.sendRedirect("/Kmarket/index.do");
		}
		else
		{
			resp.sendRedirect("/Kmarket/member/login.do?success=100");
		}
	}
}