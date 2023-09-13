package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.CS_BoardDAO;
import kr.co.kmarket.dto.CS_BoardDTO;

public enum CS_BoardService {
	INSTANCE;

	private CS_BoardDAO dao = CS_BoardDAO.getInstance();
	

	public void insertCS_Board(CS_BoardDTO dto) {
		dao.insertCS_Board(dto);
	}

	public CS_BoardDTO selectCS_Board(int bno) {
		return dao.selectCS_Board(bno);
	}

	public List<CS_BoardDTO> selectCS_Boards() {
		return dao.selectCS_Boards();
	}

	public void updateCS_Board(CS_BoardDTO dto) {
		dao.updateCS_Board(dto);
	}

	public void deleteCS_Board(int bno) {
		dao.deleteCS_Board(bno);
	}
}