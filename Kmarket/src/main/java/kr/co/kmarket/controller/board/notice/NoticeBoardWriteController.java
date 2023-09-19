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

@WebServlet("/cs/noticeBoard/write.do")
public class NoticeBoardWriteController extends HttpServlet {
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
		
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
		
		List<BoardCateDTO> list 
			= service.selectNoticeCate();
		
		request.setAttribute("cs", list);
		logger.info("noticeBoard_writre_Get list : " + list);
		
		request.getRequestDispatcher("/cs/noticeBoard/write.jsp").forward(request, respones);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		String uid = request.getParameter("uid");
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CS_BoardDTO dto = new CS_BoardDTO();
		dto.setUid(uid);
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setType(Integer.parseInt(type));
		dto.setTitle(title);
		dto.setContent(content);
		
		service.insertCS_Board(dto);
		logger.info("writePost dto : " + dto);
		
		respones.sendRedirect("/Kmarket/cs/noticeBoard/list.do?group="+group+"&cate="+cate);
	}
}