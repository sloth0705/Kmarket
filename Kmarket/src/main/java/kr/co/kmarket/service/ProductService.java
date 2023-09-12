package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

public enum ProductService {
	INSTANCE;

	private ProductDAO dao = ProductDAO.getInstance();

	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}

	public ProductDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}

	public List<ProductDTO> selectProducts(ProductSearchForm searchForm, int start) {
		return dao.selectProducts(searchForm, start);
	}

	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}

	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}

	public int selectCountTotal(String cate1, String cate2) {
		return dao.selectCountTotal(cate1, cate2);
	}
}