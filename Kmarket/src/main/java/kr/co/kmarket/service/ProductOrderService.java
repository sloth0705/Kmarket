package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductOrderDAO;
import kr.co.kmarket.dto.ProductOrderDTO;

public enum ProductOrderService {
	INSTANCE;

	private ProductOrderDAO dao = ProductOrderDAO.getInstance();

	public int insertProductOrder(ProductOrderDTO dto) {
		return dao.insertProductOrder(dto);
	}

	public ProductOrderDTO selectProductOrder(int ordNo) {
		return dao.selectProductOrder(ordNo);
	}

	public List<ProductOrderDTO> selectProductOrders() {
		return dao.selectProductOrders();
	}

	public void updateProductOrder(ProductOrderDTO dto) {
		dao.updateProductOrder(dto);
	}

	public void deleteProductOrder(int ordNo) {
		dao.deleteProductOrder(ordNo);
	}
}