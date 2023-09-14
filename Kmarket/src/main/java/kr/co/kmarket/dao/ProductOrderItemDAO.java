package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductOrderItemDTO;

public class ProductOrderItemDAO extends DBHelper {
	private static ProductOrderItemDAO instance = new ProductOrderItemDAO();

	public static ProductOrderItemDAO getInstance() {
		return instance;
	}

	private ProductOrderItemDAO() {

	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProductOrderItem(ProductOrderItemDTO dto) {
		try {
			psmt = getConnection().prepareStatement(ProductSQL.INSERT_PRODUCT_ORDER_ITEM);
			psmt.setInt(1, dto.getOrdNo());
			psmt.setInt(2, dto.getProdNo());
			psmt.setInt(3, dto.getCount());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("insertProductOrderItem error : " + e.getMessage());
		}
	}

	public ProductOrderItemDTO selectProductOrderItem(int ordNo) {
		ProductOrderItemDTO dto = null;
		return dto;
	}

	public List<ProductOrderItemDTO> selectProductOrderItems() {
		List<ProductOrderItemDTO> productOrderItems = new ArrayList<>();
		return productOrderItems;
	}

	public void updateProductOrderItem(ProductOrderItemDTO dto) {

	}

	public void deleteProductOrderItem(int ordNo) {

	}
}