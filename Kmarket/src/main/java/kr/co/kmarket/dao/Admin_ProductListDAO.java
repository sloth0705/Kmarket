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
	
	String sql = "";
	public void insertProduct(ProductDTO dto ) {
		try {
			conn = getConnection(); 
			psmt = conn.prepareStatement("INSERT INTO `km_product` SET " + "`thumb1`=?," + "`prodNo`=?,"
					+ "`prodName`=?," + "`price`=?," + "`discount`=?," + "`point`=?," + "`stock`=?," 
					+ "`seller`=?," + "`hit`=?"); 
			 // 쿼리에 값을 세팅한다.
            // 여기서 1, 2, 3은 첫번째, 두번째, 세번째 위치홀더 라는 뜻
			psmt.setString(1, dto.getThumb1());
			psmt.setInt(2, dto.getProdNo());
			psmt.setString(3, dto.getProdName());
			psmt.setInt(4, dto.getPrice());
			psmt.setInt(5, dto.getDiscount());
			psmt.setInt(6, dto.getPoint());
			psmt.setInt(7, dto.getStock());
			psmt.setString(8, dto.getSeller());
			psmt.setInt(9, dto.getHit());
			
		} catch (Exception e) {
			logger.error("insertProduct() error : " + e.getMessage());
			
		} 
		
	}
	// 상세 정보
	public ProductDTO selectProduct(String prodNo) {
		ProductDTO dto = null;
		try {
			sql = "";
			/* psmt = getConnection().prepareStatement(sql ""); */
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
	public List<ProductDTO> selectProducts(/* ProductSearchForm searchForm, int start */) {
		List<ProductDTO> products = new ArrayList<>();
		sql = "";
		try {
			psmt = getConnection().prepareStatement("SELECT `thumb1`, `prodNo`, `prodName`, `price`, "
					+ "`discount`, `point`, `stock`, `seller`, `hit` FROM `km_product`");
		
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
	
	public void updateProduct() {

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
