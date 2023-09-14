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

	public ProductOrderDTO selectProductOrder(String ordNo) {
		ProductOrderDTO dto = null;
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_PRODUCT_ORDER);
			psmt.setString(1, ordNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new ProductOrderDTO();
				dto.setOrdNo(rs.getInt("ordNo"));
				dto.setOrdUid(rs.getString("ordUid"));
				dto.setOrdCount(rs.getInt("ordCount"));
				dto.setOrdPrice(rs.getInt("ordPrice"));
				dto.setOrdDiscount(rs.getInt("ordDiscount"));
				dto.setOrdDelivery(rs.getInt("ordDelivery"));
				dto.setSavePoint(rs.getInt("savePoint"));
				dto.setUsedPoint(rs.getInt("usedPoint"));
				dto.setOrdTotPrice(rs.getInt("ordTotPrice"));
				dto.setRecipName(rs.getString("recipName"));
				dto.setRecipHp(rs.getString("recipHp"));
				dto.setRecipZip(rs.getString("recipZip"));
				dto.setRecipAddr1(rs.getString("recipAddr1"));
				dto.setRecipAddr2(rs.getString("recipAddr2"));
				dto.setOrdPayment(rs.getInt("ordPayment"));
				dto.setOrdComplete(rs.getInt("ordComplete"));
				dto.setOrdDate(rs.getString("ordDate"));
				dto.setOrdUser(rs.getString("name"));
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductOrder error : " + e.getMessage());
		}
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