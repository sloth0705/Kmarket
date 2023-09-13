package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductCartDAO;
import kr.co.kmarket.dto.ProductCartDTO;

public enum ProductCartService {
	INSTANCE;

	private ProductCartDAO dao = ProductCartDAO.getInstance();

	public void insertProductCart(ProductCartDTO dto) {
		dao.insertProductCart(dto);
	}

	public ProductCartDTO selectProductCart(int cartNo) {
		return dao.selectProductCart(cartNo);
	}

	public List<ProductCartDTO> selectProductCarts(String uid) {
		return dao.selectProductCarts(uid);
	}

	public void updateProductCart(ProductCartDTO dto) {
		dao.updateProductCart(dto);
	}

	public void deleteProductCart(int cartNo) {
		dao.deleteProductCart(cartNo);
	}
}