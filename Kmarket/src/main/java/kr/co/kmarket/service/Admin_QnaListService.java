package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.Admin_CsQnaListDAO;
import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.BoardTypeDTO;

public enum Admin_QnaListService {
	INSTANCE;
	
	private Admin_CsQnaListDAO dao = Admin_CsQnaListDAO.getInstance();
	
	// qna 글 쓸 때 cate 가져오기
		public List<BoardCateDTO> selectBoardCate(){
			return dao.selectBoardCate();
		}
		
		// notice 글 쓸 때 cate 가져오기
		public List<BoardCateDTO> selectNoticeCate(){
			return dao.selectNoticeCate();
		}
		
		// cate별로 type 가져오기
		public List<BoardTypeDTO> selectBoardType(String cate){
			return dao.selectBoardType(cate);
		}
}
