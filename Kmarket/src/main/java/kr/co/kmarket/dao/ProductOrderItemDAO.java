package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductDTO;
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

	public List<ProductOrderItemDTO> selectProductOrderItems(String ordNo) {
		List<ProductOrderItemDTO> productOrderItems = new ArrayList<>();
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_PRODUCT_ORDER_ITEMS);
			psmt.setString(1, ordNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductOrderItemDTO piDto = new ProductOrderItemDTO();
				piDto.setOrdNo(rs.getInt("ordNo"));
				piDto.setProdNo(rs.getInt("prodNo"));
				piDto.setCount(rs.getInt("count"));

				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt("prodNo"));
				dto.setProdCate1(rs.getInt("prodCate1"));
				dto.setProdCate2(rs.getInt("prodCate2"));
				dto.setProdName(rs.getString("prodName"));
				dto.setDescript(rs.getString("descript"));
				dto.setCompany(rs.getString("company"));
				dto.setSeller(rs.getString("seller"));
				dto.setPrice(rs.getInt("price"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setPoint(rs.getInt("point"));
				dto.setStock(rs.getInt("stock"));
				dto.setSold(rs.getInt("sold"));
				dto.setDelivery(rs.getInt("delivery"));
				dto.setHit(rs.getInt("hit"));
				dto.setScore(rs.getInt("score"));
				dto.setReview(rs.getInt("review"));
				dto.setThumb1(rs.getString("thumb1"));
				dto.setThumb2(rs.getString("thumb2"));
				dto.setThumb3(rs.getString("thumb3"));
				dto.setDetail(rs.getString("detail"));
				dto.setStatus(rs.getString("status"));
				dto.setDuty(rs.getString("duty"));
				dto.setReceipt(rs.getString("receipt"));
				dto.setBizType(rs.getString("bizType"));
				dto.setOrigin(rs.getString("origin"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getString("rdate"));
				dto.setEtc1(rs.getInt("etc1"));
				dto.setEtc2(rs.getInt("etc2"));
				dto.setEtc3(rs.getString("etc3"));
				dto.setEtc4(rs.getString("etc4"));
				dto.setEtc5(rs.getString("etc5"));
				piDto.setProduct(dto);
				productOrderItems.add(piDto);
			}
			close();
		} catch (Exception e) {
			logger.error("SelectProductOrderItems error : " + e.getMessage());
		}
		return productOrderItems;
	}

	public void updateProductOrderItem(ProductOrderItemDTO dto) {

	}

	public void deleteProductOrderItem(int ordNo) {

	}
}