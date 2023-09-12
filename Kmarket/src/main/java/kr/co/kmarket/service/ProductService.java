package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dto.ProductDTO;

public enum ProductService {
	INSTANCE;

	private ProductDAO dao = ProductDAO.getInstance();

	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}

	public ProductDTO selectProduct(int prodNo) {
		return dao.selectProduct(prodNo);
	}

	public List<ProductDTO> selectProducts() {
		return dao.selectProducts();
	}

	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}

	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
}