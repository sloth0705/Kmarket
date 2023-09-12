package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductCartDTO;

public class ProductCartDAO extends DBHelper {
	private static ProductCartDAO instance;

	public static ProductCartDAO getInstance() {
		return instance;
	}

	private ProductCartDAO() {

	}

	public void insertProductCart(ProductCartDTO dto) {

	}

	public ProductCartDTO selectProductCart(int cartNo) {
		ProductCartDTO dto = null;
		return dto;
	}

	public List<ProductCartDTO> selectProductCarts() {
		List<ProductCartDTO> productCarts = new ArrayList<>();
		return productCarts;
	}

	public void updateProductCart(ProductCartDTO dto) {

	}

	public void deleteProductCart(int cartNo) {

	}
}