package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductReviewDTO;

public class ProductReviewDAO extends DBHelper {
	private static ProductReviewDAO instance;

	public static ProductReviewDAO getInstance() {
		return instance;
	}

	private ProductReviewDAO() {

	}

	public void insertProductReview(ProductReviewDTO dto) {

	}

	public ProductReviewDTO selectProductReview(int revNo) {
		ProductReviewDTO dto = null;
		return dto;
	}

	public List<ProductReviewDTO> selectProductReviews() {
		List<ProductReviewDTO> productReviews = new ArrayList<>();
		return productReviews;
	}

	public void updateProductReview(ProductReviewDTO dto) {

	}

	public void deleteProductReview(int revNo) {

	}
}