package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.CateSQL;
import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.dto.ProductCate1DTO;

public class ProductCate1DAO extends DBHelper {
	private static ProductCate1DAO instance = new ProductCate1DAO();

	public static ProductCate1DAO getInstance() {
		return instance;
	}

	private ProductCate1DAO() {

	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertProductCate1(ProductCate1DTO dto) {

	}

	public ProductCate1DTO selectProductCate1(int cate1) {
		ProductCate1DTO dto = null;
		return dto;
	}

	public List<ProductCate1DTO> selectProductCate1s() {
		List<ProductCate1DTO> productCate1s = new ArrayList<>();
		try {
			stmt = getConnection().createStatement();
			rs = stmt.executeQuery(CateSQL.SELECT_CATE1S);
			while (rs.next()) {
				ProductCate1DTO dto = new ProductCate1DTO();
				dto.setCate1(rs.getInt("cate1"));
				dto.setC1Name(rs.getString("c1Name"));
				dto.setCss(rs.getString("css"));
				productCate1s.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductCate1s error : " + e.getMessage());
		}
		return productCate1s;
	}

	public void updateProductCate1(MemberDTO dto) {

	}

	public void deleteProductCate1(int cate1) {

	}
}