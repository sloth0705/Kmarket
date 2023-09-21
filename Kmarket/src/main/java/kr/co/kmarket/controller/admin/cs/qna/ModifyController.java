package kr.co.kmarket.controller.admin.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cs/qna/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = -3096577418337856923L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/modify.jsp");
		dispatcher.forward(req, resp);
	}
}
