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

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 5993656574541195493L;
	private Admin_ProductService pService = Admin_ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 검색조건과 검색내용 가져오기
		String searchType = req.getParameter("searchType");
		if (searchType == null || searchType.equals("null")) {
			searchType = "prodName";
		}
		String search = req.getParameter("search");
		if (search == null || search.equals("null")) {
			search = "";
		}
		// 현재 페이지 가져오기
		String pg = req.getParameter("pg");

		// 세션에서 현재 로그인 사용자의 정보를 가져온다
		MemberDTO member = (MemberDTO) req.getSession().getAttribute("sessMember");
		
		// 검색조건들을 모으기 위한 form
		ProductSearchForm searchForm = new ProductSearchForm();
		searchForm.setUid(member.getUid());
		searchForm.setLevel(member.getLevel());
		searchForm.setSearch(search);
		searchForm.setSearchType(searchType);
		
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
		total = pService.selectCountTotal(member.getUid(), member.getLevel(), searchForm);

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

		List<ProductDTO> products = pService.selectProducts(searchForm, start);

		logger.info("listnumber" + products.size());

		req.setAttribute("pg", pg);
		req.setAttribute("search", search);
		req.setAttribute("searchType", searchType);
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
