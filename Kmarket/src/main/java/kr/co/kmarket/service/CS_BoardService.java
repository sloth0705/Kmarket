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
	public List<CS_BoardDTO> selectCS_Boards(String group, String cate, int start, int pageCount) {
		if(cate.equals("All")) {
			return dao.selectCS_Boards(group, start, pageCount);
		}else {
			return dao.selectBoardTypes(group, cate, start, pageCount);
		}
	}
	
	// 게시판 전체 개수 조회
	public int selectCountTotal(String group, String cate) {
		if(group.equals("notice")) {
			return dao.selectCountTotal_NoticeAll();
		}else {
			return dao.selectCountTotal(group, cate);
		}
	}

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
	
	// index notice 
	public List<CS_BoardDTO> indexNoticeBoard(){
		return dao.indexNoticeBoard();
	}
	
	// index qna 
	public List<CS_BoardDTO> indexQnABoard(){
		return dao.indexQnABoard();
	}
	
	// 게시판 수정
	public void updateCS_Board(CS_BoardDTO dto) {
		dao.updateCS_Board(dto);
	}

	// 게시판 삭제
	public void deleteCS_Board(int bno) {
		dao.deleteCS_Board(bno);
	}
	
	
	
	
	
	// 페이지 마지막 번호
	public int getLastPageNum(int total, int pageCount) {
		int lastPageNum = 0;
		
		if(total % pageCount == 0){
			lastPageNum = total / pageCount;
		}else{
			lastPageNum = total / pageCount + 1;
		}
		
		return lastPageNum;
	}
	
	// 페이지 그룹 계산
	public int[] getPageGroupNum(int currentPage, int lastPageNum, int pageCount) {
		int pageGroupCurrent 
			= (int) Math.ceil(currentPage / (double)pageCount);
		int pageGroupStart 
			= (pageGroupCurrent - 1) * pageCount + 1;
		int pageGroupEnd 
			= pageGroupCurrent * pageCount;
		
		// 마지막 페이지 보여줌
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		
		int[] result = { pageGroupStart, pageGroupEnd };
		
		return result;
	}
	
	// 페이지 시작번호
	public int getPageStartNum(int total, int currentPage, int pageCount) {
		int start = (currentPage - 1) * pageCount;
		return total - start;
	}
	
	// 현재 페이지 번호
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null) currentPage = Integer.parseInt(pg);	
		
		return currentPage;
	}
	
	// Limit 시작번호
	public int getStartNum(int currentPage, int pageCount) {
		return (currentPage - 1) * pageCount;
	}
}