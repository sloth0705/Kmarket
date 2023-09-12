package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductOrderDTO;

public class ProductOrderDAO extends DBHelper {
	private static ProductOrderDAO instance;

	public static ProductOrderDAO getInstance() {
		return instance;
	}

	private ProductOrderDAO() {

	}

	public void insertProductOrder(ProductOrderDTO dto) {

	}

	public ProductOrderDTO selectProductOrder(int ordNo) {
		ProductOrderDTO dto = null;
		return dto;
	}

	public List<ProductOrderDTO> selectProductOrders() {
		List<ProductOrderDTO> productOrders = new ArrayList<>();
		return productOrders;
	}

	public void updateProductOrder(ProductOrderDTO dto) {

	}

	public void deleteProductOrder(int ordNo) {

	}
}