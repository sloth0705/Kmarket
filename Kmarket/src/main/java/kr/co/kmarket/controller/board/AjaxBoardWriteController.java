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

import com.google.gson.Gson;

import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.service.CS_BoardService;

@WebServlet("/cs/Board/ajaxWrite.do")
public class AjaxBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 5233589879373746478L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		logger.info("qan ajaxWrite page init==========================");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		// cate 명을 가져옴
		String optionValue = request.getParameter("optionValue");
		logger.info("ajax value : " + optionValue);
		
		List<BoardTypeDTO> type
			= service.selectBoardType(optionValue);
		logger.info("ajax type list : " + type);
		
		respones.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		String strJsons = gson.toJson(type);
		respones.getWriter().print(strJsons);
		logger.info("ajax type Json" + strJsons);
	}
	
}