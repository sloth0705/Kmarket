package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.CS_BoardDAO;
import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.dto.CS_BoardDTO;

public enum CS_BoardService {
	INSTANCE;

	private CS_BoardDAO dao = CS_BoardDAO.getInstance();
	

	// 게시판 등록
	public void insertCS_Board(CS_BoardDTO dto) {
		dao.insertCS_Board(dto);
	}

	// 게시판 글 조회
	public CS_BoardDTO selectCS_Board(int bno) {
		return dao.selectCS_Board(bno);
	}

	// 게시판 목록 조회
	public List<CS_BoardDTO> selectCS_Boards(String group, String cate) {
		if(cate.equals("All")) {
			return dao.selectCS_Boards(group);
		}else {
			return dao.selectBoardTypes(group, cate);
		}
	}

	// qna 글 쓸 때 cate 가져오기
	public List<BoardCateDTO> selectQnABoardCate(){
		return dao.selectQnABoardCate();
	}
	
	// qna 게시판 글 쓸 때 cate별로 type 가져오기
	public List<BoardTypeDTO> selectQnABoardType(String cate){
		return dao.selectQnABoardType(cate);
	}
	
	// 게시판 수정
	public void updateCS_Board(CS_BoardDTO dto) {
		dao.updateCS_Board(dto);
	}

	// 게시판 삭제
	public void deleteCS_Board(int bno) {
		dao.deleteCS_Board(bno);
	}
}