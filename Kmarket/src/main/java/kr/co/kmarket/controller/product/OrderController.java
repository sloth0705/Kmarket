package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.ProductCartDTO;
import kr.co.kmarket.service.ProductCartService;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = -8655047175919956311L;
	private ProductCartService cService = ProductCartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cartNos = req.getParameterValues("chk");
		StringBuilder sb = new StringBuilder("(");

		for (int i = 0; i < cartNos.length; i++) {
			sb.append(cartNos[i]);
			if (i < cartNos.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		String in = sb.toString();
		logger.info("order in : " + in);
		List<ProductCartDTO> carts = cService.selectCheckedProductCarts(in);
		req.setAttribute("carts", carts);
		logger.info("order carts : " + carts.size());
		req.getRequestDispatcher("/product/order.jsp").forward(req, resp);
	}
}