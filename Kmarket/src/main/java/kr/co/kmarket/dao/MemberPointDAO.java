package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberPointDTO;

public class MemberPointDAO extends DBHelper {
	private static MemberPointDAO instance;

	public static MemberPointDAO getInstance() {
		return instance;
	}

	private MemberPointDAO() {

	}

	public void insertMemberPoint(MemberPointDTO dto) {

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