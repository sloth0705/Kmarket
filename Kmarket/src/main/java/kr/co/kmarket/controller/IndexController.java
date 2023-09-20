package kr.co.kmarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 5783589879373746478L;
	private ProductService pService = ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		// 쿠키 가져오기
		Cookie[] cookies = req.getCookies();
		if (cookies != null)
		{
			for (Cookie tempCookie : cookies)
			{
				if (tempCookie.getName().equals("uid"))
				{
					HttpSession session = req.getSession();
					session.setAttribute("uid", tempCookie.getValue());
				}
			}
		}
		
		// 베스트 상품, 히트 상품 등 상품 가져오기
		List<ProductDTO> bestProducts = pService.selectProductsByReasonLimit(" a.`score` ", 5);
		List<ProductDTO> hitProducts = pService.selectProductsByReasonLimit(" a.`hit` ", 8);
		List<ProductDTO> scoreProducts = pService.selectProductsByReasonLimit(" a.`score` ", 8);
		List<ProductDTO> rdateProducts = pService.selectProductsByReasonLimit(" a.`rdate` ", 8);
		List<ProductDTO> discountProducts = pService.selectProductsByReasonLimit(" a.`discount` ", 8);
		
		req.setAttribute("bestProducts", bestProducts);
		req.setAttribute("hitProducts", hitProducts);
		req.setAttribute("scoreProducts", scoreProducts);
		req.setAttribute("rdateProducts", rdateProducts);
		req.setAttribute("discountProducts", discountProducts);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}