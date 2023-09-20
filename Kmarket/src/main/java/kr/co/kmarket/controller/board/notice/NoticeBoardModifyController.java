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

import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;
import kr.co.kmarket.util.BoardMap;

@WebServlet("/cs/noticeBoard/modify.do")
public class NoticeBoardModifyController extends HttpServlet {
	private static final long serialVersionUID = -255669837665243361L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		String bno = request.getParameter("bno");
		
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
		
		List<BoardCateDTO> list 
			= service.selectNoticeCate();
		request.setAttribute("cs", list);
		
		
		CS_BoardDTO dto 
			= service.selectCS_Board(Integer.parseInt(bno));
		request.setAttribute("board", dto);
				
		request.getRequestDispatcher("/cs/noticeBoard/modify.jsp").forward(request, respones);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String strBno = request.getParameter("bno");
		int bno = Integer.parseInt(strBno);
		
		CS_BoardDTO dto = new CS_BoardDTO();
		dto.setCate(cate);
		dto.setType(Integer.parseInt(type));
		dto.setTitle(title);
		dto.setContent(content);
		dto.setBno(bno);
		
		service.updateCS_Board(dto);
		logger.info("updateNoitce Post dto : " + dto);
		
		respones.sendRedirect("/Kmarket/cs/noticeBoard/view.do?group="+group+"&cate="+cate+"&bno="+bno);
	}
}