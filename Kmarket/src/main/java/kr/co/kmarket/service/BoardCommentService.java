package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.BoardCommentDAO;
import kr.co.kmarket.dto.BoardCommentDTO;

public enum BoardCommentService {

	INSTANCE;

	private BoardCommentDAO dao = BoardCommentDAO.getInstance();
	
	public void insertComment(BoardCommentDTO dto) {
		dao.insertComment(dto);
	}
	
	public List<BoardCommentDTO> selectComment(int re_bno){
		return dao.selectComment(re_bno);
	}
}
