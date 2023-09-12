package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductCate1DAO;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductCate1DTO;

public enum ProductCate1Service {
	INSTANCE;

	private ProductCate1DAO dao = ProductCate1DAO.getInstance();

	public void insertProductCate1(ProductCate1DTO dto) {
		dao.insertProductCate1(dto);
	}

	public ProductCate1DTO selectProductCate1(int cate1) {
		return dao.selectProductCate1(cate1);
	}

	public List<ProductCate1DTO> selectProductCate1s() {
		return dao.selectProductCate1s();
	}

	public void updateProductCate1(MemberDTO dto) {
		dao.updateProductCate1(dto);
	}

	public void deleteProductCate1(int cate1) {
		dao.deleteProductCate1(cate1);
	}
}