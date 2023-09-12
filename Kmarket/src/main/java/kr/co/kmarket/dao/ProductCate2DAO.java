package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductCate2DTO;

public class ProductCate2DAO extends DBHelper {
	private static ProductCate2DAO instance;

	public static ProductCate2DAO getInstance() {
		return instance;
	}

	private ProductCate2DAO() {

	}

	public void insertProductCate2(ProductCate2DTO dto) {

	}

	public ProductCate2DTO selectProductCate2(int cate1) {
		ProductCate2DTO dto = null;
		return dto;
	}

	public List<ProductCate2DTO> selectProductCate2s() {
		List<ProductCate2DTO> productCate2s = new ArrayList<>();
		return productCate2s;
	}

	public void updateProductCate2(ProductCate2DTO dto) {

	}

	public void deleteProductCate2(int cate1) {

	}
}