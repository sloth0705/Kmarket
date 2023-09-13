package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.MemberDTO;

public class MemberDAO extends DBHelper {
	
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertMember(MemberDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getPass());
			psmt.setString(3, dto.getName());
			psmt.setString(4, dto.getGender());
			psmt.setString(5, dto.getHp());
			psmt.setString(6, dto.getEmail());
			psmt.setInt(7, dto.getType());
			psmt.setInt(8, dto.getLevel());
			psmt.setString(9, dto.getZip());
			psmt.setString(10, dto.getAddr1());
			psmt.setString(11, dto.getAddr2());
			psmt.setString(12, dto.getCompany());
			psmt.setString(13, dto.getCeo());
			psmt.setString(14, dto.getBizRegNum());
			psmt.setString(15, dto.getComRegNum());
			psmt.setString(16, dto.getTel());
			psmt.setString(17, dto.getManager());
			psmt.setString(18, dto.getManagerHp());
			psmt.setString(19, dto.getFax());
			psmt.setString(20, dto.getRegip());
			
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error("insertUser() error : " + e.getMessage());
		}
	}

	public MemberDTO selectMember(String uid) {
		MemberDTO dto = null;
		return dto;
	}

	public List<MemberDTO> selectMembers() {
		List<MemberDTO> members = new ArrayList<>();
		return members;
	}

	public void updateMember(MemberDTO dto) {

	}

	public void deleteMember(String uid) {

	}
}