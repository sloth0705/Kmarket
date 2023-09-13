package kr.co.kmarket.controller.board;

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

@WebServlet("/cs/board/view.do")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 3283589879373746478L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		logger.info("BoardView_get group : " + group);
		
		
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		logger.info("BoardView_get title : " + title);
		logger.info("BoardView_get content : " + content);
		
		CS_BoardDTO dto 
			= service.selectCS_Board(Integer.parseInt(bno));
		request.setAttribute("cs", dto);
		
		
		request.getRequestDispatcher("/cs/board/view.jsp").forward(request, respones);
	}
}