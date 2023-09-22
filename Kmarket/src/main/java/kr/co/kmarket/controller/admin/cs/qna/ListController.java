package kr.co.kmarket.controller.admin.cs.qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cs/qna/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = -6756270650563163841L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pg = req.getParameter("pg");
		
		/* 
		 
	    페이지 관련 변수 선언
		int currentPage = 1;
		int total = 0;
		int lastPageNum = 0;
		int pageGroupCurrent = 1;
		int pageGroupStart = 1;
		int pageGroupEnd = 0;
		int pageStartNum = 0;

		 현재 페이지 계산
		if (pg != null) {
			currentPage = Integer.parseInt(pg);
		}

		 Limit 시작값 개선
		int start = (currentPage - 1) * 10;

		 전체 개시물 갯수 조회
		total = p2Service.selectCountTotal("15", "10");

		if (total % 10 == 0) {
			lastPageNum = total / 10;
		} else {
			lastPageNum = total / 10 + 1;
		}

		 페이지 그룹 계산
		pageGroupCurrent = (int) Math.ceil(currentPage / 10.0);
		pageGroupStart = (pageGroupCurrent - 1) * 10 + 1;
		pageGroupEnd = pageGroupCurrent * 10;

		if (pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}

		 페이지 시작번호 계산
		pageStartNum = total - start;

		*/
		
		// 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}
}
