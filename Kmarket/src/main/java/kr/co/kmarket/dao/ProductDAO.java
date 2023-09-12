package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.SQL;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

public class ProductDAO extends DBHelper {
	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	private ProductDAO() {

	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertProduct(ProductDTO dto) {

	}

	public ProductDTO selectProduct(String prodNo) {
		ProductDTO dto = null;
		try {
			psmt = getConnection().prepareStatement(SQL.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				dto = new ProductDTO();
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
			}
		} catch (Exception e) {
			logger.error("selectProduct error : " + e.getMessage());
		}
		return dto;
	}

	public List<ProductDTO> selectProducts(ProductSearchForm searchForm, int start) {
		List<ProductDTO> products = new ArrayList<>();
		try {
			psmt = getConnection().prepareStatement(SQL.SELECT_PRODUCTS);
			psmt.setString(1, searchForm.getCate1());
			psmt.setString(2, searchForm.getCate2());
			psmt.setString(3, orderReason(searchForm.getOrd()));
			psmt.setInt(4, start);
			rs = psmt.executeQuery();
			while (rs.next()) {
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
				products.add(dto);
			}
		} catch (Exception e) {
			logger.error("selectProducts error : " + e.getMessage());
		}
		return products;
	}

	public void updateProduct(ProductDTO dto) {

	}

	public void deleteProduct(int prodNo) {

	}

	public String orderReason(String ord) {
		String reason = "a.`rdate` DESC";
		if (ord.equals("1")) { // 판매 많은 순

		} else if (ord.equals("2")) { // 낮은 가격순
			reason = "a.`price ASC`";
		} else if (ord.equals("3")) { // 높은 가격순
			reason = "a.`price DESC`";
		} else if (ord.equals("4")) { // 평점 높은순

		} else if (ord.equals("5")) { // 후기 많은순

		} else if (ord.equals("6")) { // 최근 등록순
			reason = "a.`rdate` DESC";
		}
		return reason;
	}

	public int selectCountTotal(String cate1, String cate2) {
		int count = 0;
		try {
			psmt = getConnection().prepareStatement(SQL.SELECT_PRODUCT_COUNT_TOTAL);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error("selectCountTotal error : " + e.getMessage());
		}
		return count;
	}
}