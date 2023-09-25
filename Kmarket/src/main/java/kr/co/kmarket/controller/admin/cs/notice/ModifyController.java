package kr.co.kmarket.controller.admin.cs.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;

@WebServlet("/admin/cs/notice/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 725113203961381933L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		String cate = req.getParameter("cate");
		String bno  = req.getParameter("bno");
		CS_BoardDTO dto = service.selectCS_Board(Integer.parseInt(bno));
		
		req.setAttribute("type", type);
		req.setAttribute("bno", bno);
		req.setAttribute("cate", cate);
		req.setAttribute("title", dto.getTitle());
		req.setAttribute("content", dto.getContent());
		
		logger.info("doGet type : " + type);
		logger.info("doGet bno : " + bno);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/modify.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String strBno  = req.getParameter("bno");
		String strType = req.getParameter("type");
		String cate    = req.getParameter("cate");
		String title   = req.getParameter("title");
		String content = req.getParameter("content");
		logger.info("doPost cate : " + cate);
		logger.info("doPost bno : " + strBno);
		logger.info("doPost type : " + strType);
		int type = Integer.parseInt(strType);
		int bno  = Integer.parseInt(strBno);
		
		CS_BoardDTO dto = new CS_BoardDTO();
		dto.setType(type);
		dto.setBno(bno);
		dto.setCate(cate);
		dto.setTitle(title);
		dto.setContent(content);
		
		service.updateCS_Board(dto);
		
		resp.sendRedirect("/Kmarket/admin/cs/notice/list.do");
	}
}
