package kr.co.kmarket.controller.admin.cs.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.service.CS_BoardService;

@WebServlet("/admin/cs/faq/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = -943159225248098454L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String pg = req.getParameter("pg");
	
		// cate 명을 가져옴
		String optionValue = req.getParameter("optionValue");
		logger.info("ajax value : " + optionValue);
		
		List<BoardTypeDTO> type
			= service.selectBoardType(optionValue);
		logger.info("ajax type list : " + type);
		
		resp.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String strJsons = gson.toJson(type);
		resp.getWriter().print(strJsons);
		logger.info("ajax type Json" + strJsons);
	
		List<BoardCateDTO> cateDTO 
		= service.selectBoardCate();
		req.setAttribute("cate", cateDTO);
		
		// 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
}
