package kr.co.kmarket.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.BoardCateDTO;
import kr.co.kmarket.dto.BoardTypeDTO;
import kr.co.kmarket.dto.CS_BoardDTO;

public class Admin_CsQnaListDAO extends DBHelper {
	private static Admin_CsQnaListDAO instance = new Admin_CsQnaListDAO();
	public static Admin_CsQnaListDAO getInstance( ) {
		return instance;
	}
	private Admin_CsQnaListDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	String sql = "";
	
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
						+ " AND b.cate = ? "
						+ " ORDER BY bno DESC";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, group);
				psmt.setString(2, cate);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					CS_BoardDTO dto = new CS_BoardDTO();
					// ? dto = getCS(rs);
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
	public List<BoardCateDTO> selectBoardCate(){
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
		
		
	// notice 글 쓸 때 cate 가져오기
	public List<BoardCateDTO> selectNoticeCate(){
		List<BoardCateDTO> list = new ArrayList<>();
		conn = getConnection();
		sql = "SELECT "
				+ "	DISTINCT bc.`cate`,"
					+ " bc.cateName "
				+ " FROM km_cs_boardCate AS bc "
				+ " JOIN km_cs_boardType AS bt "
				+ " ON bc.`cate` = bt.`cate` "
				+ " WHERE `type` > 20";
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
		public List<BoardTypeDTO> selectBoardType(String cate){
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
		
		
}
