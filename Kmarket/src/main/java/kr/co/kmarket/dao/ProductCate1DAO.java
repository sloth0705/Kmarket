package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductCate1DTO;

public class ProductCate1DAO extends DBHelper {
	private static ProductCate1DAO instance;

	public static ProductCate1DAO getInstance() {
		return instance;
	}

	private ProductCate1DAO() {

	}

	public void insertProductCate1(ProductCate1DTO dto) {

	}

	public ProductCate1DTO selectProductCate1(int cate1) {
		ProductCate1DTO dto = null;
		return dto;
	}

	public List<ProductCate1DTO> selectProductCate1s() {
		List<ProductCate1DTO> productCate1s = new ArrayList<>();
		return productCate1s;
	}

	public void updateProductCate1(MemberDTO dto) {

	}

	public void deleteProductCate1(int cate1) {

	}
}