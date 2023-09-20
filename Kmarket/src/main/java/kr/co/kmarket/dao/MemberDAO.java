package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.MemberDTO;

public class MemberDAO extends DBHelper {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertMember(MemberDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT INTO `km_member` SET " + "`uid`=?, " + "`pass`=SHA2(?, 256), "
					+ "`name`=?, " + "`gender`=?, " + "`hp`=?, " + "`email`=?, " + "`type`=?, " + "`level`=?, "
					+ "`zip`=?, " + "`addr1`=?, " + "`addr2`=?, " + "`company`=?, " + "`ceo`=?, " + "`bizRegNum`=?, "
					+ "`comRegNum`=?, " + "`tel`=?, " + "`manager`=?, " + "`managerHp`=?, " + "`fax`=?, "
					+ "`regip`=?, " + "`rdate`=NOW()");
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

		} catch (Exception e) {
			logger.error("insertUser() error : " + e.getMessage());
		}
	}

	public MemberDTO selectMember(String uid, String pass) {

		MemberDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?, 256)");
			psmt.setString(1, uid);
			psmt.setString(2, pass);

			rs = psmt.executeQuery();

			if (rs.next()) {
				dto = new MemberDTO();
				dto.setUid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setType(rs.getString(7));
				dto.setPoint(rs.getInt(8));
				dto.setLevel(rs.getString(9));
				dto.setZip(rs.getString(10));
				dto.setAddr1(rs.getString(11));
				dto.setAddr2(rs.getString(12));
				dto.setCompany(rs.getString(13));
				dto.setCeo(rs.getString(14));
				dto.setBizRegNum(rs.getString(15));
				dto.setComRegNum(rs.getString(16));
				dto.setTel(rs.getString(17));
				dto.setManager(rs.getString(18));
				dto.setManagerHp(rs.getString(19));
				dto.setFax(rs.getString(20));
				dto.setRegip(rs.getString(21));
				dto.setWdate(rs.getString(22));
				dto.setRdate(rs.getString(23));
			}

			close();

		} catch (Exception e) {
			logger.error("selectMember() error : " + e.getMessage());
		}

		return dto;
	}
	
	public MemberDTO selectCookie(String uid) { // 쿠키 조회
		
		MemberDTO dto = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_member` WHERE uid=?");
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			if (rs.next())
			{
				dto = new MemberDTO();
				dto.setUid(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setEmail(rs.getString(6));
				dto.setType(rs.getString(7));
				dto.setPoint(rs.getInt(8));
				dto.setLevel(rs.getString(9));
				dto.setZip(rs.getString(10));
				dto.setAddr1(rs.getString(11));
				dto.setAddr2(rs.getString(12));
				dto.setCompany(rs.getString(13));
				dto.setCeo(rs.getString(14));
				dto.setBizRegNum(rs.getString(15));
				dto.setComRegNum(rs.getString(16));
				dto.setTel(rs.getString(17));
				dto.setManager(rs.getString(18));
				dto.setManagerHp(rs.getString(19));
				dto.setFax(rs.getString(20));
				dto.setRegip(rs.getString(21));
				dto.setWdate(rs.getString(22));
				dto.setRdate(rs.getString(23));
			}
			
			close();
			
		}catch(Exception e) {
			logger.error("selectCookie() error : " + e.getMessage());
		}
		
		return dto;
	}

	public int selectCountUid(String uid) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `uid`=?");
			psmt.setString(1, uid);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountUid() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountHp(String hp) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `hp`=?");
			psmt.setString(1, hp);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountHp() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountEmail(String email) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `email`=?");
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountEmail() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountCompany(String company) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `company`=?");
			psmt.setString(1, company);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountCompany() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountBizRegNum(String bizRegNum) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `bizRegNum`=?");
			psmt.setString(1, bizRegNum);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountBizRegNum() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountComRegNum(String comRegNum) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `comRegNum`=?");
			psmt.setString(1, comRegNum);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountComRegNum() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountTel(String tel) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `tel`=?");
			psmt.setString(1, tel);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountTel() error : " + e.getMessage());
		}

		return result;
	}

	public int selectCountFax(String fax) {

		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(*) FROM `km_member` WHERE `fax`=?");
			psmt.setString(1, fax);

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

			close();

		} catch (Exception e) {
			logger.error("selectCountFax() error : " + e.getMessage());
		}

		return result;
	}
	
	public List<MemberDTO> selectMembers() {
		List<MemberDTO> members = new ArrayList<>();
		return members;
	}

	public void updateMember(MemberDTO dto) {

	}

	public void deleteMember(String uid) {

	}

	public void usePoint(String ordUid, String usedPoint) {
		try {
			psmt = getConnection().prepareStatement(ProductSQL.USE_POINT);
			psmt.setString(1, usedPoint);
			psmt.setString(2, ordUid);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("usePoint error : " + e.getMessage());
		}
	}

	public void savePoint(String ordUid, int savePoint) {
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SAVE_POINT);
			psmt.setInt(1, savePoint);
			psmt.setString(2, ordUid);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("savePoint error : " + e.getMessage());
		}
	}
}