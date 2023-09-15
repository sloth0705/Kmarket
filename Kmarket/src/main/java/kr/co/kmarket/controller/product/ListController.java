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

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;
import kr.co.kmarket.service.ProductService;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 8126906125168496409L;
	private ProductService pService = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pg = req.getParameter("pg");
		String ord = req.getParameter("ord");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		if (ord == null || ord.equals("")) {
			ord = "1";
		}
		ProductSearchForm searchForm = new ProductSearchForm();
		searchForm.setPg(pg);
		searchForm.setOrd(ord);
		searchForm.setCate1(cate1);
		searchForm.setCate2(cate2);

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
		total = pService.selectCountTotal(cate1, cate2);

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

		// 현재 페이지 게시물 조회
		List<ProductDTO> products = pService.selectProducts(searchForm, start);

		req.setAttribute("pg", pg);
		req.setAttribute("ord", ord);
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("products", products);
		logger.info("product listController 조회 개수 : " + products.size());

		req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
	}
}