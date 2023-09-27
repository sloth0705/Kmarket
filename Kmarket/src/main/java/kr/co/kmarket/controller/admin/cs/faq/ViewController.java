package kr.co.kmarket.controller.admin.cs.faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;

@WebServlet("/admin/cs/faq/view.do")
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = -7982008927920136441L;
	private CS_BoardService service = CS_BoardService.INSTANCE;
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
		req.setAttribute("cateName", dto.getCateName());
		req.setAttribute("type", dto.getType());
		req.setAttribute("title", dto.getTitle());
		req.setAttribute("content", dto.getContent());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/faq/view.jsp");
		dispatcher.forward(req, resp);
	}
}
