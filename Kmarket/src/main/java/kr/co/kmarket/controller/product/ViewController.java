package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = -1433171064190938748L;
	private ProductService pService = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		ProductDTO product = pService.selectProduct(prodNo);
		logger.info("viewController : " + product.toString());
		req.setAttribute("product", product);
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.getRequestDispatcher("/product/view.jsp").forward(req, resp);
	}
}