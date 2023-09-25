package kr.co.kmarket.controller.board.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;
import kr.co.kmarket.util.BoardMap;

@WebServlet("/cs/qnaBoard/list.do")
public class QnABoardListController extends HttpServlet {
	private static final long serialVersionUID = -2018502673393107208L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		logger.info("qan list page init==========================");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		String pg = request.getParameter("pg");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
		
		// 현재 페이지 번호
		int currentPage = service.getCurrentPage(pg);
		
		// 시작 인덱스
		int pageCount = 5;
		int start = service.getStartNum(currentPage, pageCount);
		
		// 전체 게시물 갯수 
		int total = service.selectCountTotal(group, cate);
		
		// 마지막 페이지 번호
		int lastPageNum = service.getLastPageNum(total, pageCount);
		
		// 페이지 그룹 start, end 번호
		int[] result 
			= service.getPageGroupNum(currentPage, lastPageNum, pageCount);
		
		// 페이지 시작번호
		int pageStartNum = service.getPageStartNum(total, currentPage, pageCount);
		
		List<CS_BoardDTO> list 
			= service.selectCS_Boards(group, cate, start, pageCount);
		
		request.setAttribute("cs", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPageNum", lastPageNum);
		request.setAttribute("pageGroupStart", result[0]);
		request.setAttribute("pageGroupEnd", result[1]);
		request.setAttribute("pageStartNum", pageStartNum+1);
		logger.info("BoardList_get list : " + list);
		
		request.getRequestDispatcher("/cs/qnaBoard/list.jsp").forward(request, respones);
	}
}