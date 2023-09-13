package kr.co.kmarket.controller.board.notice;

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

@WebServlet("/cs/noticeBoard/view.do")
public class NoticeBoardViewController extends HttpServlet {
	private static final long serialVersionUID = 4444489879373746478L;

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
		
		
		String bno = request.getParameter("bno");
		
		CS_BoardDTO dto 
			= service.selectCS_Board(Integer.parseInt(bno));
		request.setAttribute("cs", dto);
		
		
		request.getRequestDispatcher("/cs/noticeBoard/view.jsp").forward(request, respones);
	}
}