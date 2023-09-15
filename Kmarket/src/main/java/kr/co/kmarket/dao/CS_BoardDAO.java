package kr.co.kmarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.CS_BoardDTO;

public class CS_BoardDAO extends DBHelper {
	private static CS_BoardDAO instance = new CS_BoardDAO();
	public static CS_BoardDAO getInstance() {
		return instance;
	}
	private CS_BoardDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	int result = 0;
	String sql = "";
	
	// cs 게시판 등록
	public void insertCS_Board(CS_BoardDTO dto) {
		conn = getConnection();
		try {
			sql = "INSERT INTO km_cs_board SET "
					+ " uid = ?, "
					+ " group = ?, "
					+ " cate = ?, "
					+ " type = ?, "
					+ " title = ?, "
					+ " content = ?, "
					+ " rdate = NOW()";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getGroup());
			psmt.setString(3, dto.getCate());
			psmt.setInt(4, dto.getType());
			psmt.setString(5, dto.getTitle());
			psmt.setString(6, dto.getContent());
			psmt.executeUpdate();
			
			logger.info("insertCS_Board dto : " + dto);
			close();
		} catch (SQLException e) {
			logger.error("insertCS_Board : " + e.getMessage());
		}
	}

	// 게시판 글 보기
	public CS_BoardDTO selectCS_Board(int bno) {
		CS_BoardDTO dto = null;
		conn = getConnection();
		try {
			sql = "SELECT * FROM km_cs_board "
					+ " WHERE bno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
		
			if(rs.next()) {
				dto = new CS_BoardDTO();
				dto = getCS(rs);
			}
			logger.info("selectCS_Board dto : " + dto);
			close();
		} catch (SQLException e) {
			logger.error("selectCS_Board : " + e.getMessage());
		}
		return dto;
	}

	// 게시판 전체 조회
	public List<CS_BoardDTO> selectCS_Boards(String group) {
		List<CS_BoardDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			sql = "SELECT * FROM km_cs_board "
					+ " WHERE `group` = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			
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
	
	// cate에 따라 게시판 조회
	public List<CS_BoardDTO> selectBoardTypes(String group, String typeName, String cate) {
		List<CS_BoardDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			sql = "SELECT * "
					+ " FROM km_cs_board AS b "
					+ " JOIN km_cs_boardType AS bt "
						+ " ON b.`type` = bt.`type` "
					+ " JOIN km_cs_boardCate AS bc "
						+ " ON b.cate = bc.cate "
					+ " WHERE `group` = ? "
					+ " AND bt.`typeName` = ? "
					+ " AND b.cate = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, group);
			psmt.setString(2, typeName);
			psmt.setString(3, cate);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CS_BoardDTO dto = new CS_BoardDTO();
				dto = getCS(rs);
				dto.setTypeName(rs.getString("typeName"));
				dto.setCateName(rs.getString("cateName"));
				list.add(dto);
			}
			logger.info("selectBoardTypes list : " + list);
			close();
		} catch (SQLException e) {
			logger.error("selectBoardTypes : " + e.getMessage());
		}
		return list;
	}

	// qna 
	public List<CS_BoardDTO> selectQnABoard(){
		List<CS_BoardDTO> list = new ArrayList<>();
		conn = getConnection();
		sql = "SELECT * FROM km_cs_board AS b "
				+ "LEFT JOIN km_cs_boardCate AS bc "
					+ " ON b.cate = bc.cate "
				+ "LEFT JOIN km_cs_boardType AS bt "
					+ " ON b.type = bt.type";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CS_BoardDTO dto = new CS_BoardDTO();
				dto = getCS(rs);
				dto.setCateName(rs.getString("cateName"));
				dto.setTypeName(rs.getString("typeName"));
				list.add(dto);
			}
			close();
		} catch (SQLException e) {
			logger.error("selectQnABoard : " + e.getMessage());
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
			dto.setGroup(rs.getString("group"));
			dto.setCate(rs.getString("cate"));
			dto.setType(rs.getInt("type"));
			dto.setTitle(rs.getString("title"));
			dto.setContent(rs.getString("content"));
			dto.setRdate(rs.getString("rdate"));
		}catch(Exception e) {}
		
		return dto;		
	}
}