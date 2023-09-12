package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductReviewDAO;
import kr.co.kmarket.dto.ProductReviewDTO;

public enum ProductReviewService {
	INSTANCE;

	private ProductReviewDAO dao = ProductReviewDAO.getInstance();

	public void insertProductReview(ProductReviewDTO dto) {
		dao.insertProductReview(dto);
	}

	public ProductReviewDTO selectProductReview(int revNo) {
		return dao.selectProductReview(revNo);
	}

	public List<ProductReviewDTO> selectProductReviews() {
		return dao.selectProductReviews();
	}

	public void updateProductReview(ProductReviewDTO dto) {
		dao.updateProductReview(dto);
	}

	public void deleteProductReview(int revNo) {
		dao.deleteProductReview(revNo);
	}
}