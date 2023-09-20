package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = -5922397494151458422L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate(); // session 초기화
		
		// 로그인 관련 쿠키 삭제
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
		{
	        for (Cookie tempCookie : cookies)
	        {
	            if (tempCookie.getName().equals("memberCookie"))
	            {
	                tempCookie.setMaxAge(0);
	                tempCookie.setPath("/");
	                resp.addCookie(tempCookie);
	            }
	        }
	    }
		
		resp.sendRedirect("/Kmarket/index.do?success=200");
	}
}
