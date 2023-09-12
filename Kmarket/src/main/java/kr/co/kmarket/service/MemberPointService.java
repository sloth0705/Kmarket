package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.MemberPointDAO;
import kr.co.kmarket.dto.MemberPointDTO;

public enum MemberPointService {
	INSTANCE;

	private MemberPointDAO dao = MemberPointDAO.getInstance();

	public void insertMemberPoint(MemberPointDTO dto) {
		dao.insertMemberPoint(dto);
	}

	public MemberPointDTO selectMemberPoint(int pointNo) {
		return dao.selectMemberPoint(pointNo);
	}

	public List<MemberPointDTO> selectMemberPoints() {
		return dao.selectMemberPoints();
	}

	public void updateMemberPoint(MemberPointDTO dto) {
		dao.updateMemberPoint(dto);
	}

	public void deleteMemberPoint(String uid) {
		dao.deleteMemberPoint(uid);
	}
}