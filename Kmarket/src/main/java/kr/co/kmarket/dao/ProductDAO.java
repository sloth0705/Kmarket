package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductDTO;

public class ProductDAO extends DBHelper {
	private static ProductDAO instance;

	public static ProductDAO getInstance() {
		return instance;
	}

	private ProductDAO() {

	}

	public void insertProduct(ProductDTO dto) {

	}

	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = null;
		return dto;
	}

	public List<ProductDTO> selectProducts() {
		List<ProductDTO> products = new ArrayList<>();
		return products;
	}

	public void updateProduct(ProductDTO dto) {

	}

	public void deleteProduct(int prodNo) {

	}
}