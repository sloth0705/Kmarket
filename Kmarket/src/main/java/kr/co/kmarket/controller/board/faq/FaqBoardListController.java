package kr.co.kmarket.controller.board.faq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;
import kr.co.kmarket.util.BoardMap;

@WebServlet("/cs/faqBoard/list.do")
public class FaqBoardListController extends HttpServlet {
	private static final long serialVersionUID = 2283589879373746478L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
	
		int start = 0;
		/*
		 * pageCount가 cate 별로 처리가 아니라
		 * 모든 faq에 대한 list를 보여주다보니
		 * 0, 10이 아닌 pageCount를 임시적으로 높게 잡아줘야
		 * 해당 더보기를 눌렀을 때 limit 10개 제한을 걸어놔서
		 * 10개만 보여줄 수 있게 된다.
		 */ 
		int pageCount = 100000;
		List<CS_BoardDTO> cates 
			= service.selectCS_Boards(group, cate, start, pageCount);
		logger.info("cates size : " + cates.size());
		List<BoardTypeDTO> types
			=service.selectBoardType(cate);
		
		// BoardTypeDTO에 있는 주석을 일단 봐
		for(BoardTypeDTO type : types) {
			List<CS_BoardDTO> csBoard = new ArrayList<>();
			for(CS_BoardDTO board : cates) {
				if(type.getType() == board.getType()) {
					csBoard.add(board);
				}
			}
			type.setDto(csBoard);
		}
		
		request.setAttribute("cs", cates);
		logger.info("BoardList_get cate : " + cates);
		request.setAttribute("types", types);
		logger.info("BoardList_get types : " + types);
		
		request.getRequestDispatcher("/cs/faqBoard/list.jsp").forward(request, respones);
	}
}