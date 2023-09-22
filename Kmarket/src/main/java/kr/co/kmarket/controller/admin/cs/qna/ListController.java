package kr.co.kmarket.controller.admin.cs.qna;

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

import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.service.Admin_QnaListService;

@WebServlet("/admin/cs/qna/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = -6756270650563163841L;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Admin_QnaListService service = Admin_QnaListService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}
}
