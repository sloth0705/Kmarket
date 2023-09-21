package kr.co.kmarket.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;
import kr.co.kmarket.service.Admin_ProductService;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 5993656574541195493L;
	private Admin_ProductService pService = Admin_ProductService.INSTANCE; 
	private ProductService p2Service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String thumb1   = req.getParameter("thumb1");
		String prodNo   = req.getParameter("prodNo");
		String prodName = req.getParameter("prodName");
		String price    = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point	= req.getParameter("point");
		String stock 	= req.getParameter("stock");
		String seller 	= req.getParameter("seller");
		String hit 		= req.getParameter("hit");
		String pg = req.getParameter("pg");
		MemberDTO member = (MemberDTO)req.getSession().getAttribute("sessMember");
		
		// 페이지 관련 변수 선언
				int currentPage = 1;
				int total = 0;
				int lastPageNum = 0;
				int pageGroupCurrent = 1;
				int pageGroupStart = 1;
				int pageGroupEnd = 0;
				int pageStartNum = 0;

				// 현재 페이지 계산
				if (pg != null) {
					currentPage = Integer.parseInt(pg);
				}

				// Limit 시작값 개선
				int start = (currentPage - 1) * 10;

				// 전체 개시물 갯수 조회
				total = p2Service.selectCountTotal("15", "10");

				if (total % 10 == 0) {
					lastPageNum = total / 10;
				} else {
					lastPageNum = total / 10 + 1;
				}

				// 페이지 그룹 계산
				pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
				pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
				pageGroupEnd = pageGroupCurrent * 10;

				if (pageGroupEnd > lastPageNum) {
					pageGroupEnd = lastPageNum;
				}

				// 페이지 시작번호 계산
				pageStartNum = total - start;

		
	
		ProductSearchForm searchForm = new ProductSearchForm();
		searchForm.setUid(member.getUid()); 
		List<ProductDTO> products = pService.selectProducts(searchForm, start);

		logger.info("listnumber" + products.size());
		
		req.setAttribute("pg", pg);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("products", products);
		
		
		// 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	

}
