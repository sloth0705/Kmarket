package kr.co.kmarket.controller.board;

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

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1283589879373746478L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		request.setAttribute("group", group);
		request.setAttribute("cate", cate);
		
		
		List<CS_BoardDTO> boards = service.indexNoticeBoard();
		request.setAttribute("boards", boards);
		logger.info("index notice : "+boards);
		
		List<CS_BoardDTO> qnas = service.indexQnABoard();
		request.setAttribute("qnas", qnas);
		logger.info("index qna : "+qnas);
		
		request.getRequestDispatcher("/cs/index.jsp").forward(request, respones);
	}
}