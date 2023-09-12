package kr.co.kmarket.service;

import kr.co.kmarket.dao.MemberTermsDAO;
import kr.co.kmarket.dto.MemberTermsDTO;

public enum MemberTermsService {
	INSTANCE;

	private MemberTermsDAO dao = MemberTermsDAO.getInstance();

	public void insertMemberTerms(MemberTermsDTO dto) {
		dao.insertMemberTerms(dto);
	}

	public MemberTermsDTO selectMemberTerms() {
		return dao.selectMemberTerms();
	}

	public void updateMemberTerms(MemberTermsDTO dto) {
		dao.updateMemberTerms(dto);
	}

	public void deleteMemberTerms() {
		dao.deleteMemberTerms();
	}
}