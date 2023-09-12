package kr.co.kmarket.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1283589879373746478L;

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		request.getRequestDispatcher("/cs/index.jsp").forward(request, respones);
	}
}