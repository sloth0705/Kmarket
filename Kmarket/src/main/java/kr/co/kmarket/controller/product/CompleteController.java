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

import kr.co.kmarket.dto.ProductOrderDTO;
import kr.co.kmarket.dto.ProductOrderItemDTO;
import kr.co.kmarket.service.ProductOrderItemService;
import kr.co.kmarket.service.ProductOrderService;

@WebServlet("/product/complete.do")
public class CompleteController extends HttpServlet {
	private static final long serialVersionUID = -5199746995597033101L;
	private ProductOrderService poService = ProductOrderService.INSTANCE;
	private ProductOrderItemService piService = ProductOrderItemService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ordNo = req.getParameter("ordNo");
		ProductOrderDTO order = poService.selectProductOrder(ordNo);
		List<ProductOrderItemDTO> orderItems = piService.selectProductOrderItems(ordNo);

		req.setAttribute("order", order);
		req.setAttribute("orderItems", orderItems);
		logger.info("orderItems size : " + orderItems.size());
		req.getRequestDispatcher("/product/complete.jsp").forward(req, resp);
	}
}