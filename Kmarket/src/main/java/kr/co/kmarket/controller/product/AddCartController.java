package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.ProductCartDTO;
import kr.co.kmarket.service.ProductCartService;

@WebServlet("/product/addCart.do")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 6132215455500182765L;
	private ProductCartService cService = ProductCartService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");

		ProductCartDTO dto = new ProductCartDTO();
		dto.setUid(uid);
		dto.setProdNo(prodNo);
		dto.setCount(count);

		int result = cService.insertProductCart(dto);
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("result", result);
		jsonData.toString();
		
		resp.getWriter().print(jsonData);
	}
}