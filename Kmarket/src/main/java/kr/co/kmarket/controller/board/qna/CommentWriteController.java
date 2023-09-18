package kr.co.kmarket.controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.BoardCommentDTO;
import kr.co.kmarket.service.BoardCommentService;

@WebServlet("/cs/comment/write.do")
public class CommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 4218502673393107208L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private BoardCommentService service = BoardCommentService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		logger.info("qan write page init==========================");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse respones) throws ServletException, IOException {
		
		String group = request.getParameter("group");
		String cate = request.getParameter("cate");
		
		String uid = request.getParameter("uid");
		String bno = request.getParameter("bno");
		String content = request.getParameter("content");
		int re_bno = Integer.parseInt(bno);
		
		BoardCommentDTO dto = new BoardCommentDTO();
		dto.setRe_bno(re_bno);
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setUid(uid);
		dto.setContent(content);
		
		service.insertComment(dto);
		logger.info("commentWrite_post dto : "+dto);
		
		respones.sendRedirect("/Kmarket/cs/qnaBoard/list.do?group="+group+"&cate="+cate+"&bno="+re_bno);
		
	}
}