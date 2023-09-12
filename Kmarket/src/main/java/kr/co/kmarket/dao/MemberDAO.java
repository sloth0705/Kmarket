package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberDTO;

public class MemberDAO extends DBHelper {
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {

	}

	public void insertMember(MemberDTO dto) {

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