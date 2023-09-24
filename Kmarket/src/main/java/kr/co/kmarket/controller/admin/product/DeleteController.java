package kr.co.kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.Admin_ProductService;

@WebServlet("/admin/product/delete.do")
public class DeleteController extends HttpServlet{
	private static final long serialVersionUID = -5852102586282270390L;
	private Admin_ProductService pService = Admin_ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] prodNos = req.getParameterValues("chk");
		StringBuilder in = new StringBuilder("(");
		for (int i = 0; i < prodNos.length; i++) {
			in.append(prodNos[i]);
			if (i < prodNos.length - 1) {
				in.append(", ");
			}
		}
		in.append(")");
		pService.deleteProduct(in.toString());
		resp.sendRedirect("/Kmarket/admin/product/list.do");
	}
}