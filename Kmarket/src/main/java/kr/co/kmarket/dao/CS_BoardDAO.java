package kr.co.kmarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.BoardTypeDTO;
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
					+ " `group` = ?, "
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
			sql = "SELECT * FROM km_cs_board AS b "
					+ " JOIN km_cs_boardType AS bt "
						+ " ON b.cate = bt.cate "
						+ " AND b.`type` = bt.`type`"
					+ " WHERE bno = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
		
			if(rs.next()) {
				dto = new CS_BoardDTO();
				dto = getCS(rs);
				dto.setTypeName(rs.getString("typeName"));
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
			sql = "SELECT * FROM km_cs_board AS b "
					+ " JOIN km_cs_boardType AS bt "
						+ " ON b.`type` = bt.`type` "
						+ " AND b.`cate` = bt.`cate`"
					+ " JOIN km_cs_boardCate AS bc"
						+ " ON b.`cate` = bc.`cate` "
					+ " WHERE `group` = 'notice'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CS_BoardDTO dto = new CS_BoardDTO();
				dto = getCS(rs);
				dto.setTypeName(rs.getString("typeName"));
				dto.setCateName(rs.getString("cateName"));
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
	public List<CS_BoardDTO> selectBoardTypes(String group, String cate) {
		List<CS_BoardDTO> list = new ArrayList<>();
		conn = getConnection();
		try {
			sql = "SELECT * "
					+ " FROM km_cs_board AS b "
					+ " JOIN km_cs_boardType AS bt "
						+ " ON b.`type` = bt.`type` "
						+ " AND b.`cate` = bt.`cate`"
					+ " JOIN km_cs_boardCate AS bc"
						+ " ON b.`cate` = bc.`cate` "
					+ " WHERE `group` = ? "
					+ " AND b.cate = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, group);
			psmt.setString(2, cate);
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

	// qna 글 쓸 때 cate 가져오기
	public List<BoardCateDTO> selectQnABoardCate(){
		List<BoardCateDTO> list = new ArrayList<>();
		conn = getConnection();
		sql = "SELECT "
				+ "	DISTINCT bc.`cate`,"
					+ " bc.cateName "
				+ " FROM km_cs_boardCate AS bc "
				+ " JOIN km_cs_boardType AS bt "
				+ " ON bc.`cate` = bt.`cate` "
				+ " WHERE `type` < 20";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardCateDTO dto = new BoardCateDTO();
				dto.setCate(rs.getString("cate"));
				dto.setCateName(rs.getString("CateName"));
				list.add(dto);
			}
			logger.info("selectQnABoardCate list : " + list);
			close();
		} catch (SQLException e) {
			logger.error("selectQnABoardCate : " + e.getMessage());
		}
		return list;
	}
	
	// qna 글 쓸 때 cate 별로 type 가져오기
	public List<BoardTypeDTO> selectQnABoardType(String cate){
		List<BoardTypeDTO> list = new ArrayList<>();
		conn = getConnection();
		sql = "SELECT * FROM km_cs_boardType "
				+ " WHERE cate = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardTypeDTO dto = new BoardTypeDTO();
				dto.setCate(rs.getString("cate"));
				dto.setType(rs.getInt("type"));
				dto.setTypeName(rs.getString("typeName"));
				list.add(dto);
			}
			logger.info("selectQnABoardType list : " + list);
			close();
		} catch (SQLException e) {
			logger.error("selectQnABoardType : " + e.getMessage());
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