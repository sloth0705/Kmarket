package kr.co.kmarket.controller.board.qna;

import java.io.IOException;

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

@WebServlet("/cs/qnaBoard/write.do")
public class QnABoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 4233589879373746478L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		logger.info("qan write page init==========================");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		String cateName = BoardMap.map.get(cate);
		request.setAttribute("cateName", cateName);
		
		request.getRequestDispatcher("/cs/qnaBoard/write.jsp").forward(request, respones);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		String type = request.getParameter("type");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CS_BoardDTO dto = new CS_BoardDTO();
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setType(Integer.parseInt(type));
		dto.setTitle(title);
		dto.setContent(content);
		
		service.insertCS_Board(dto);
		logger.info("writePost dto : " + dto);
		
		respones.sendRedirect("/Kmarket/cs/qnaBoard/list.do?group="+group+"&cate="+cate);
		
	}
}