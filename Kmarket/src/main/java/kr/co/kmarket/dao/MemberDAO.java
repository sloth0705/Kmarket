package kr.co.kmarket.dao;

import kr.co.kmarket.db.DBHelper;

public class MemberDAO extends DBHelper {
	private static MemberDAO instance;

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {

	}
	
	public void insertMember() {
		
	}
}