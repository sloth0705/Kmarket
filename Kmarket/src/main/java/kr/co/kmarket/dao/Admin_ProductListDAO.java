/*
 * 날짜: 2023/09/15
 * 작업자: 조유빈
 * 내용: 관리자 - 상품관리 - 상품현황 페이지에 상품 목록 구현
 */

package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

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
	// 상세 정보
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
	
	// 목록 전체 불러오기
	public List<ProductDTO> selectProducts(ProductSearchForm searchForm, int start) {
		List<ProductDTO> products = new ArrayList<>();
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_PRODUCTS);
			psmt.setInt(1, start);
			rs = psmt.executeQuery(); // db의 데이터를 조회할 때 사용
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setThumb1(rs.getString("thumb1"));
				dto.setProdNo(rs.getInt("prodNo"));
				dto.setProdName(rs.getString("prodName"));
				dto.setPrice(rs.getInt("price"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setPoint(rs.getInt("point"));
				dto.setStock(rs.getInt("stock"));
				dto.setSeller(rs.getString("seller"));
				dto.setHit(rs.getInt("hit"));
				products.add(dto);
			}
			close();
		
		}catch (Exception e) {
			logger.error("selectProducts error : " + e.getMessage());
		}
		return products;
	}
	
	public void updateProduct(ProductDTO dto) {

	}

	public void deleteProduct(int prodNo) {

	}
	
	public List<ProductDTO> deleteProducts(int prodNo) {
		List<ProductDTO> products = new ArrayList<>();
		conn = getConnection();
		try {

					
			
		} catch (Exception e) {
			logger.error("deleteProducts error : " + e.getMessage());
		}
		return products;

	}
	
	
	
	

}
