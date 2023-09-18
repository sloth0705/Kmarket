package kr.co.kmarket.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.BoardCommentDTO;

public class BoardCommentDAO extends DBHelper {

	private static BoardCommentDAO instance = new BoardCommentDAO();
	public static BoardCommentDAO getInstance() {
		return instance;
	}
	private BoardCommentDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	int result = 0;
	String sql = "";
	
	// 댓글 쓰기
	public void insertComment(BoardCommentDTO dto) {
		conn = getConnection();
		sql = "INSERT INTO km_comment SET "
				+ " cno = ?, "
				+ " re_bno = ?, "
				+ " `group` = ?, "
				+ " cate = ?, "
				+ " uid = ?, "
				+ " content = ?, "
				+ " rdate = NOW()";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getCno());
			psmt.setInt(2, dto.getRe_bno());
			psmt.setString(3, dto.getGroup());
			psmt.setString(4, dto.getCate());
			psmt.setString(5, dto.getUid());
			psmt.setString(6, dto.getContent());
			psmt.executeUpdate();
			
			logger.info("insertComment dto : " + dto);
			close();
		} catch (SQLException e) {
			logger.error("insertComment : " + e.getMessage());
		}
	}
	
	// 댓글 확인
	public List<BoardCommentDTO> selectComment(int re_bno){
		List<BoardCommentDTO> list = new ArrayList<>();
		conn = getConnection();
		sql = "SELECT * FROM km_comment "
				+ " WHERE re_bno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, re_bno);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardCommentDTO dto = new BoardCommentDTO();
				dto = getComment(rs);
				list.add(dto);
			}
			logger.info("selectComment list : " + list);
			close();
		} catch (SQLException e) {
			logger.error("selectComment err : " + e.getMessage());
		}
		return list;
	}
	
	
	public BoardCommentDTO getComment(ResultSet rs) {
		BoardCommentDTO dto = null;
		try {
			dto = new BoardCommentDTO();
			dto.setCno(rs.getInt("cno"));
			dto.setRe_bno(rs.getInt("re_bno"));
			dto.setGroup(rs.getString("group"));
			dto.setCate(rs.getString("cate"));
			dto.setUid(rs.getString("uid"));
			dto.setContent(rs.getString("content"));
			dto.setRdate(rs.getString("rdate"));
		}catch(Exception e) {}
		
		return dto;		
	}
}
