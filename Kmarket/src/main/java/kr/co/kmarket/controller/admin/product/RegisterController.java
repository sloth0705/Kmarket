package kr.co.kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet{

	private static final long serialVersionUID = -575977800525097241L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}

}
