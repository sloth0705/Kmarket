package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductOrderItemDTO;

public class ProductOrderItemDAO extends DBHelper {
	private static ProductOrderItemDAO instance;

	public static ProductOrderItemDAO getInstance() {
		return instance;
	}

	private ProductOrderItemDAO() {

	}

	public void insertProductOrderItem(ProductOrderItemDTO dto) {

	}

	public ProductOrderItemDTO selectProductOrderItem(int ordNo) {
		ProductOrderItemDTO dto = null;
		return dto;
	}

	public List<ProductOrderItemDTO> selectProductOrderItems() {
		List<ProductOrderItemDTO> productOrderItems = new ArrayList<>();
		return productOrderItems;
	}

	public void updateProductOrderItem(ProductOrderItemDTO dto) {

	}

	public void deleteProductOrderItem(int ordNo) {

	}
}