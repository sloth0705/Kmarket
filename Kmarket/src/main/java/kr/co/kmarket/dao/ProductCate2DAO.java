package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.ProductCate2DTO;

public class ProductCate2DAO extends DBHelper {
	private static ProductCate2DAO instance = new ProductCate2DAO();
	public static ProductCate2DAO getInstance() {
		return instance;
	}
	private ProductCate2DAO() {}
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProductCate2(ProductCate2DTO dto) {

	}

	public ProductCate2DTO selectProductCate2(int cate1) {
		ProductCate2DTO dto = null;
		return dto;
	}

	public List<ProductCate2DTO> selectProductCate2s(String cate1) {
		
		List<ProductCate2DTO> productCate2s = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product_cate2` WHERE `cate1`=?");
			psmt.setString(1, cate1);
			
			rs = psmt.executeQuery();
			
			while (rs.next())
			{
				ProductCate2DTO dto = new ProductCate2DTO();
				dto.setCate1(rs.getInt(1));
				dto.setCate2(rs.getInt(2));
				dto.setC2Name(rs.getString(3));
				
				productCate2s.add(dto);
				logger.info("dto : "+dto);
				logger.info("List<ProductCate2DTO> productCate2s : " + productCate2s);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error("selectProductCate2s() error : " + e.getMessage());
		}
		return productCate2s;
	}
	
	public List<ProductCate2DTO> selectProductCate2s() {
		
		List<ProductCate2DTO> productCate2s = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM `km_product_cate2`");
			
			while (rs.next())
			{
				ProductCate2DTO dto = new ProductCate2DTO();
				dto.setCate1(rs.getInt(1));
				dto.setCate2(rs.getInt(2));
				dto.setC2Name(rs.getString(3));
				
				productCate2s.add(dto);
				logger.info("dto : "+dto);
				logger.info("List<ProductCate2DTO> productCate2s : " + productCate2s);
			}
			
			close();
			
		}catch(Exception e) {
			logger.error("selectProductCate2s() error : " + e.getMessage());
		}
		return productCate2s;
	}

	public void updateProductCate2(ProductCate2DTO dto) {

	}

	public void deleteProductCate2(int cate1) {

	}
}