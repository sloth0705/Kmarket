package kr.co.kmarket.controller.admin.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.ProductCate2DTO;
import kr.co.kmarket.service.ProductCate2Service;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = -575977800525097241L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductCate2Service service = ProductCate2Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		logger.info("cate1 : " + cate1);
		
		List<ProductCate2DTO> cate2 = service.selectProductCate2s(cate1);
		logger.info("cate2 : " + cate2);
		
		Map<String, Object> data = new HashMap<>();
		data.put("cate2", cate2);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(data); // 전송
	}
}
