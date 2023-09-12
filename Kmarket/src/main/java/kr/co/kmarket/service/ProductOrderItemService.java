package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductOrderItemDAO;
import kr.co.kmarket.dto.ProductOrderItemDTO;

public enum ProductOrderItemService {
	INSTANCE;

	private ProductOrderItemDAO dao = ProductOrderItemDAO.getInstance();

	public void insertProductOrderItem(ProductOrderItemDTO dto) {
		dao.insertProductOrderItem(dto);
	}

	public ProductOrderItemDTO selectProductOrderItem(int ordNo) {
		return dao.selectProductOrderItem(ordNo);
	}

	public List<ProductOrderItemDTO> selectProductOrderItems() {
		return dao.selectProductOrderItems();
	}

	public void updateProductOrderItem(ProductOrderItemDTO dto) {
		dao.updateProductOrderItem(dto);
	}

	public void deleteProductOrderItem(int ordNo) {
		dao.deleteProductOrderItem(ordNo);
	}
}