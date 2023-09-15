/*
 * 날짜: 2023/09/15
 * 작업자: 조유빈
 * 내용: 관리자 - 상품관리 - 상품현황 페이지에 상품 목록 구현
 */

package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductDTO;

public class Admin_ProductListDAO extends DBHelper {
	private static Admin_ProductListDAO instance = new Admin_ProductListDAO();
	
	public static Admin_ProductListDAO getInstance() {
		return instance;
	}
	
	private Admin_ProductListDAO() {
		
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto ) {
		
	}
	
	public ProductDTO selectProduct(String prodNo) {
		ProductDTO dto = null;
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new ProductDTO();
				dto.setThumb1(rs.getString("thumb1"));
				dto.setProdNo(rs.getInt("prodNo"));
				dto.setProdName(rs.getString("prodName"));
				dto.setPrice(rs.getInt("price"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setPoint(rs.getInt("point"));
				dto.setStock(rs.getInt("stock"));
				dto.setSeller(rs.getString("seller"));
				dto.setHit(rs.getInt("hit"));
			}
			
		}catch (Exception e) {
			logger.error("selectProduct error : " + e.getMessage());
		}
		return dto;
		
	}
	
	public void updateProduct(ProductDTO dto) {

	}

	public void deleteProduct(int prodNo) {

	}
	
	
	
	
	
	

}
