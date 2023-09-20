package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.dto.MemberDTO;

public enum MemberService {
	INSTANCE;

	private MemberDAO dao = MemberDAO.getInstance();

	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}

	public MemberDTO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public MemberDTO selectCookie(String uid) {
		return dao.selectCookie(uid);
	}
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountCompany(String company) {
		return dao.selectCountCompany(company);
	}
	public int selectCountBizRegNum(String bizRegNum) {
		return dao.selectCountBizRegNum(bizRegNum);
	}
	public int selectCountComRegNum(String comRegNum) {
		return dao.selectCountComRegNum(comRegNum);
	}
	public int selectCountTel(String tel) {
		return dao.selectCountTel(tel);
	}
	public int selectCountFax(String fax) {
		return dao.selectCountFax(fax);
	}

	public List<MemberDTO> selectMembers() {
		return dao.selectMembers();
	}

	public void updateMember(MemberDTO dto) {
		dao.updateMember(dto);
	}

	public void deleteMember(String uid) {
		dao.deleteMember(uid);
	}

	public void usePoint(String ordUid, String usedPoint) {
		dao.usePoint(ordUid, usedPoint);
	}

	public void savePoint(String ordUid, int savePoint) {
		dao.savePoint(ordUid, savePoint);
	}
}