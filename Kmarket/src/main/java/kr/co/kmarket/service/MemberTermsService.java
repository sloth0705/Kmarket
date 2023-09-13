package kr.co.kmarket.service;

import kr.co.kmarket.dao.MemberTermsDAO;
import kr.co.kmarket.dto.MemberTermsDTO;

public enum MemberTermsService {
	
	INSTANCE;
	private MemberTermsDAO dao = MemberTermsDAO.getInstance();

	public MemberTermsDTO selectMemberTerms() {
		return dao.selectMemberTerms();
	}
}