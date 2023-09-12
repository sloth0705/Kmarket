package kr.co.kmarket.dao;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberTermsDTO;

public class MemberTermsDAO extends DBHelper {
	private static MemberTermsDAO instance;

	public static MemberTermsDAO getInstance() {
		return instance;
	}

	private MemberTermsDAO() {

	}
	
	public void insertMemberTerms(MemberTermsDTO dto) {

	}

	public MemberTermsDTO selectMemberTerms() {
		MemberTermsDTO dto = null;
		return dto;
	}

	public void updateMemberTerms(MemberTermsDTO dto) {

	}

	public void deleteMemberTerms() {

	}
}