package kr.co.kmarket.controller.admin.product;

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

@WebServlet("/product/cart.do")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 4894447715672818263L;
	private ProductCartService cService = ProductCartService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO: 추후 로그인 세션 구현시 세션 UID로 검색할 것
		String uid = "ppp";
		List<ProductCartDTO> carts = cService.selectProductCarts(uid);
		req.setAttribute("carts", carts);
		logger.info("장바구니 개수 : " + carts.size());
		req.getRequestDispatcher("/product/cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cartNos = req.getParameterValues("chk");
		for (String cartNo : cartNos) {
			cService.deleteProductCart(Integer.parseInt(cartNo));
		}
		resp.sendRedirect("/Kmarket/product/cart.do");
	}
}