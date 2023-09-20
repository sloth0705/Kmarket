package kr.co.kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cs/notice/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 5490256359092545978L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}
}
