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

@WebServlet("/admin/cs/notice/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 5490256359092545978L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	CS_BoardService service = CS_BoardService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bno = req.getParameter("bno");
		CS_BoardDTO dto = service.selectCS_Board(Integer.parseInt(bno));
		
		String cateName = ""; // DB에 Join 안돼있어서 cateName 불러올 수 없음. 임의로 여기서..
		if (dto.getCate().equals("All"))
		{
			cateName = "전체";
		}
		else if (dto.getCate().equals("cs"))
		{
			cateName = "고객서비스";
		}
		else if (dto.getCate().equals("safe"))
		{
			cateName = "안전거래";
		}
		else if (dto.getCate().equals("dangerProd"))
		{
			cateName = "위해상품";
		}
		else if (dto.getCate().equals("event"))
		{
			cateName = "이벤트 당첨";
		}
		
		req.setAttribute("bno", bno);
		req.setAttribute("cate", dto.getCate());
		req.setAttribute("cateName", cateName);
		req.setAttribute("type", dto.getType());
		req.setAttribute("title", dto.getTitle());
		req.setAttribute("content", dto.getContent());
		logger.info("cateName : " + cateName);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}
}
