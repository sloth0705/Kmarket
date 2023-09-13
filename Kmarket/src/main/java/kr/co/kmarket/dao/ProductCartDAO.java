package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.ProductSQL;
import kr.co.kmarket.dto.ProductCartDTO;
import kr.co.kmarket.dto.ProductDTO;

public class ProductCartDAO extends DBHelper {
	private static ProductCartDAO instance = new ProductCartDAO();

	public static ProductCartDAO getInstance() {
		return instance;
	}

	private ProductCartDAO() {

	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void insertProductCart(ProductCartDTO dto) {

	}

	public ProductCartDTO selectProductCart(int cartNo) {
		ProductCartDTO dto = null;
		return dto;
	}

	public List<ProductCartDTO> selectProductCarts(String uid) {
		List<ProductCartDTO> productCarts = new ArrayList<>();
		try {
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_PRODUCT_CARTS);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductCartDTO dto = new ProductCartDTO();
				dto.setCartNo(rs.getInt("cartNo"));
				dto.setUid(rs.getString("uid"));
				dto.setProdNo(rs.getInt("prodNo"));
				dto.setCount(rs.getInt("count"));
				dto.setRdate(rs.getString("rdate"));

				ProductDTO product = new ProductDTO();
				product.setProdName(rs.getString("prodName"));
				product.setDescript(rs.getString("descript"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setPoint(rs.getInt("point"));
				product.setDelivery(rs.getInt("delivery"));
				product.setThumb1(rs.getString("thumb1"));
				dto.setProduct(product);

				productCarts.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductCarts error : " + e.getMessage());
		}
		return productCarts;
	}

	public void updateProductCart(ProductCartDTO dto) {

	}

	public void deleteProductCart(int cartNo) {
		try {
			psmt = getConnection().prepareStatement(ProductSQL.DELETE_CART);
			psmt.setInt(1, cartNo);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error("deleteProductCart error : " + e.getMessage());
		}
	}

	public List<ProductCartDTO> selectCheckedProductCarts(String in) {
		List<ProductCartDTO> productCarts = new ArrayList<>();
		try {
			// psmt.setString(1, in)으로 값을 넘길시 IN '(1, 4)' 이런식으로 넘어가서 SQL 에러가 나온다.
			psmt = getConnection().prepareStatement(ProductSQL.SELECT_CHECKED_PRODUCT_CARTS + in);
			rs = psmt.executeQuery();
			while (rs.next()) {
				ProductCartDTO dto = new ProductCartDTO();
				dto.setCartNo(rs.getInt("cartNo"));
				dto.setUid(rs.getString("uid"));
				dto.setProdNo(rs.getInt("prodNo"));
				dto.setCount(rs.getInt("count"));
				dto.setRdate(rs.getString("rdate"));

				ProductDTO product = new ProductDTO();
				product.setProdName(rs.getString("prodName"));
				product.setDescript(rs.getString("descript"));
				product.setPrice(rs.getInt("price"));
				product.setDiscount(rs.getInt("discount"));
				product.setPoint(rs.getInt("point"));
				product.setDelivery(rs.getInt("delivery"));
				product.setThumb1(rs.getString("thumb1"));
				dto.setProduct(product);

				productCarts.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProductCarts error : " + e.getMessage());
		}
		return productCarts;
	}
}