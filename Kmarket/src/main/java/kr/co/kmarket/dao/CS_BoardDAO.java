package kr.co.kmarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.CS_BoardDTO;

public class CS_BoardDAO extends DBHelper {
	private static CS_BoardDAO instance = new CS_BoardDAO();
	public static CS_BoardDAO getInstance() {
		return instance;
	}
	private CS_BoardDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// cs 게시판 등록
	public void insertCS_Board(CS_BoardDTO dto) {
		conn = getConnection();
		try {
			psmt = conn.prepareStatement(SQL.INSERT_CS_BOARD);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getType1());
			psmt.setInt(3, dto.getType2());
			psmt.setString(4, dto.getTitle());
			psmt.setString(5, dto.getContent());
			psmt.executeUpdate();
			
			logger.info("insertCS_Board dto : " + dto);
			close();
		} catch (SQLException e) {
			logger.error("insertCS_Board : " + e.getMessage());
		}
	}

	public CS_BoardDTO selectCS_Board(int bno) {
		CS_BoardDTO dto = null;
		
		return dto;
	}

	public List<CS_BoardDTO> selectCS_Boards() {
		List<CS_BoardDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_CS_BOARDS);
			
			while(rs.next()) {
				CS_BoardDTO dto = new CS_BoardDTO();
				dto = getCS(rs);
				list.add(dto);
			}
			
			logger.info("selectCS_Boards list : " + list);
			close();
		} catch (SQLException e) {
			logger.error("selectCS_Boards : " + e.getMessage());
		}
		return list;
	}

	public void updateCS_Board(CS_BoardDTO dto) {

	}

	public void deleteCS_Board(int bno) {

	}
	
	public CS_BoardDTO getCS(ResultSet rs) {
		CS_BoardDTO dto = null;
		try {
			dto = new CS_BoardDTO();
			dto.setBno(rs.getInt("bno"));
			dto.setUid(rs.getString("uid"));
			dto.setType1(rs.getInt("type1"));
			dto.setType2(rs.getInt("type2"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRdate(rs.getString("rdate"));
		}catch(Exception e) {}
		
		return dto;		
	}
}