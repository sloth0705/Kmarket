package kr.co.kmarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 5783589879373746478L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		// 쿠키 가져오기
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
		{
			for (Cookie tempCookie : cookies)
			{
				if (tempCookie.getName().equals("uid"))
				{
					HttpSession session = req.getSession();
					session.setAttribute("uid", tempCookie.getValue());
				}
			}
		}
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}