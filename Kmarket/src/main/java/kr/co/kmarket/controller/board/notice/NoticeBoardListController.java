package kr.co.kmarket.controller.board.notice;

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

@WebServlet("/cs/noticeBoard/list.do")
public class NoticeBoardListController extends HttpServlet {
	private static final long serialVersionUID = -355669837665243361L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		String typeName = request.getParameter("typeName");
		// map의 key 값으로 value값 가져오기
		// -> key를 cate로 받아서 value값을 출력하는거임
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
		
		List<CS_BoardDTO> list 
			= service.selectCS_Boards(group, typeName, cate);
		
		request.setAttribute("cs", list);
		logger.info("BoardList_get list : " + list);
		
		request.getRequestDispatcher("/cs/noticeBoard/list.jsp").forward(request, respones);
		 
	}
}