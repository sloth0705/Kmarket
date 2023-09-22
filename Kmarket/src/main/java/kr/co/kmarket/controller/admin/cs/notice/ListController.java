package kr.co.kmarket.controller.admin.cs.notice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.CS_BoardDTO;
import kr.co.kmarket.service.CS_BoardService;
import net.sf.json.JSONObject;

@WebServlet("/admin/cs/notice/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = -3892249416934267587L;
	private CS_BoardService service = CS_BoardService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CS_BoardDTO> list = service.selectCS_Boards("notice", "All");
		req.setAttribute("listAll", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/notice/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		
		List<CS_BoardDTO> list = service.selectCS_Boards("notice", cate);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		JSONObject json = new JSONObject();
		json.put("map", map);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(json); // 전송
	}
}
