package kr.co.kmarket.controller.admin.cs.faq;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;
import net.sf.json.JSONObject;

@WebServlet("/admin/cs/faq/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = -943159225248098454L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BoardCateDTO> cateDTO 
		= service.selectBoardCate();
		logger.info(":::" + cateDTO.size());
		req.setAttribute("cateOptions", cateDTO);
		
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		String pg = req.getParameter("pg");
		logger.info("Get pg::::"+pg);
		
		// 현재 페이지 번호
		int currentPage = Integer.parseInt(pg);
		
		// 시작 인덱스
		int start = (currentPage - 1) * 5;
		
		// 전체 게시물 갯수 
		int total = service.selectCountTotal("faq", cate, type);
		
		// 마지막 페이지 번호
		int lastPageNum = service.getLastPageNum(total, 5);
		
		// 페이지 그룹 start, end 번호
		int pageGroupCurrent = (int) Math.ceil(currentPage / 5.0);
		int pageGroupStart = (pageGroupCurrent - 1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if (pageGroupEnd > lastPageNum)
			pageGroupEnd = lastPageNum;
		
		// 페이지 시작번호
		int pageStartNum = total - start;
		
		List<CS_BoardDTO> list = service.selectCS_Boards("faq", cate, type, start, 5);
		req.setAttribute("listAll", list);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", pageGroupStart);
		req.setAttribute("pageGroupEnd", pageGroupEnd);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("cate", cate);
		req.setAttribute("pg", pg);

		logger.info("currentPage는 "+currentPage);
		logger.info("start는 "+start);
		logger.info("total는 "+total);
		logger.info("lastPageNum는 "+lastPageNum);
		logger.info("pageGroupStart는 "+pageGroupStart);
		logger.info("pageGroupEnd는 "+pageGroupEnd);
		logger.info("pageStartNum는 "+pageStartNum);
		
		// 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		String type = req.getParameter("type");
		logger.info("cate는 "+cate);
		
		// 현재 페이지 번호
		// 카테고리가 변하면 목록을 다시 불러와야 하므로 페이지 값은 1이 되어야함 - 신진성
		int currentPage = 1;
		
		// 시작 인덱스
		int start = (currentPage - 1) * 10;
		
		// 전체 게시글 갯수 조회
		int total = service.selectCountTotal("faq", cate, type);
		
		// 마지막 페이지 번호
		int lastPageNum = 0;
		if (total % 5 == 0)
			lastPageNum = (total / 5);
		else
			lastPageNum = (total / 5) + 1;
		
		// 페이지그룹 start, end 번호
		int pageGroupCurrent = 1;
		int pageGroupStart   = 1;
		pageGroupCurrent = (int) Math.ceil(currentPage / 5.0);
		pageGroupStart = (pageGroupCurrent - 1) * 5 + 1;
		int pageGroupEnd = pageGroupCurrent * 5;
		
		if (pageGroupEnd > lastPageNum)
			pageGroupEnd = lastPageNum;
		
		// 페이지 시작번호
		int pageStartNum = total - start;
		
		logger.info("currentPage는 "+currentPage);
		logger.info("start는 "+start);
		logger.info("total는 "+total);
		logger.info("lastPageNum는 "+lastPageNum);
		logger.info("pageGroupStart는 "+pageGroupStart);
		logger.info("pageGroupEnd는 "+pageGroupEnd);
		logger.info("pageStartNum는 "+pageStartNum);
		
		List<CS_BoardDTO> list = service.selectCS_Boards("faq", cate, type, 0, 5);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("lastPageNum", lastPageNum);
		map.put("pageGroupStart", pageGroupStart);
		map.put("pageGroupEnd", pageGroupEnd);
		map.put("pageStartNum", pageStartNum);
		
		JSONObject json = new JSONObject();
		json.put("map", map);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(json); // 전송
	}
}
