package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.MemberPointDTO;

public class MemberPointDAO extends DBHelper {
	private static MemberPointDAO instance = new MemberPointDAO();

	public static MemberPointDAO getInstance() {
		return instance;
	}

	private MemberPointDAO() {

	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertMemberPoint(MemberPointDTO dto) {
		try {
			psmt = getConnection().prepareStatement(ProductSQL.INSERT_MEMBER_POINT);
			psmt.setString(1, dto.getUid());
			psmt.setInt(2, dto.getOrdNo());
			psmt.setInt(3, dto.getPoint());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("insertMemberPoint error : " + e.getMessage());
		}
	}

	public MemberPointDTO selectMemberPoint(int pointNo) {
		MemberPointDTO dto = null;
		return dto;
	}

	public List<MemberPointDTO> selectMemberPoints() {
		List<MemberPointDTO> memberPointDTOs = new ArrayList<>();
		return memberPointDTOs;
	}

	public void updateMemberPoint(MemberPointDTO dto) {

	}

	public void deleteMemberPoint(String uid) {

	}
}