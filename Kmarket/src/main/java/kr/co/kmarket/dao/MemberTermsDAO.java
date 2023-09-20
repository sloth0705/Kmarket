package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberTermsDTO;

public class MemberTermsDAO extends DBHelper {
	
	private static MemberTermsDAO instance = new MemberTermsDAO();
	public static MemberTermsDAO getInstance() {
		return instance;
	}
	private MemberTermsDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public MemberTermsDTO selectMemberTerms() {
		
		MemberTermsDTO dto = new MemberTermsDTO();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `km_member_terms`");
			
			if (rs.next())
			{
				dto.setTerms(rs.getString(1));
				dto.setPrivacy(rs.getString(2));
				dto.setFinance(rs.getString(3));
				dto.setLocation(rs.getString(4));
				dto.setTax(rs.getString(5));
			}
			
			close();
			
		}catch(Exception e) {
			logger.error("selectMemberTerms() error : " + e.getMessage());
		}
		
		return dto;
	}
}