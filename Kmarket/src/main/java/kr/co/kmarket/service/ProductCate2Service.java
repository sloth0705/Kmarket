package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductCate2DAO;
import kr.co.kmarket.dto.ProductCate2DTO;

public enum ProductCate2Service {
	INSTANCE;
	private ProductCate2DAO dao = ProductCate2DAO.getInstance();

	public void insertProductCate2(ProductCate2DTO dto) {
		dao.insertProductCate2(dto);
	}

	public ProductCate2DTO selectProductCate2(int cate1) {
		return dao.selectProductCate2(cate1);
	}

	public List<ProductCate2DTO> selectProductCate2s(String cate1) {
		return dao.selectProductCate2s(cate1);
	}

	public void updateProductCate2(ProductCate2DTO dto) {
		dao.updateProductCate2(dto);
	}

	public void deleteProductCate2(int cate1) {
		dao.deleteProductCate2(cate1);
	}
}