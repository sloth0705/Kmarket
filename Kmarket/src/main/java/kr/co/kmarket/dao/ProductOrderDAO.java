package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductOrderDTO;

public class ProductOrderDAO extends DBHelper {
	private static ProductOrderDAO instance = new ProductOrderDAO();

	public static ProductOrderDAO getInstance() {
		return instance;
	}

	private ProductOrderDAO() {

	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int insertProductOrder(ProductOrderDTO dto) {
		int ordNo = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(ProductSQL.INSERT_PRODUCT_ORDER);
			psmt.setString(1, dto.getOrdUid());
			psmt.setInt(2, dto.getOrdCount());
			psmt.setInt(3, dto.getOrdPrice());
			psmt.setInt(4, dto.getOrdDiscount());
			psmt.setInt(5, dto.getOrdDelivery());
			psmt.setInt(6, dto.getUsedPoint());
			psmt.setInt(7, dto.getOrdTotPrice());
			psmt.setString(8, dto.getRecipName());
			psmt.setString(9, dto.getRecipHp());
			psmt.setString(10, dto.getRecipZip());
			psmt.setString(11, dto.getRecipAddr1());
			psmt.setString(12, dto.getRecipAddr2());
			psmt.setInt(13, dto.getOrdPayment());
			psmt.executeUpdate();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ProductSQL.SELECT_MAX_ORDNO);
			conn.commit();
			if (rs.next()) {
				ordNo = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error("insertProductOrder error : " + e.getMessage());
		}
		return ordNo;
	}

	public ProductOrderDTO selectProductOrder(int ordNo) {
		ProductOrderDTO dto = null;
		return dto;
	}

	public List<ProductOrderDTO> selectProductOrders() {
		List<ProductOrderDTO> productOrders = new ArrayList<>();
		return productOrders;
	}

	public void updateProductOrder(ProductOrderDTO dto) {

	}

	public void deleteProductOrder(int ordNo) {

	}
}