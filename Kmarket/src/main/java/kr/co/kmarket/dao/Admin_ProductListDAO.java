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

	public void insertProduct(ProductDTO dto) {
		try {
			conn = getConnection();
			psmt = conn
					.prepareStatement("INSERT INTO `km_product` SET " + "`thumb1`=?," + "`prodNo`=?," + "`prodName`=?,"
							+ "`price`=?," + "`discount`=?," + "`point`=?," + "`stock`=?," + "`seller`=?," + "`hit`=?");
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
			close();
		} catch (Exception e) {
			logger.error("insertProduct() error : " + e.getMessage());

		}

	}

	// 상세 정보
	public ProductDTO selectProduct(String prodNo) {
		ProductDTO dto = null;
		try {
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
			close();
		} catch (Exception e) {
			logger.error("selectProduct error : " + e.getMessage());
		}
		return dto;

	}

	// 목록 전체 불러오기
	public List<ProductDTO> selectProducts(ProductSearchForm searchForm, int start) {
		List<ProductDTO> products = new ArrayList<>();
		try {
			// 쿼리문 생성
			// StringBuilder의 경우 일반 String보다 문자를 가공하는 속도가 빠르다.
			StringBuilder sql = new StringBuilder("SELECT a.*, b.`name` FROM `km_product` AS a JOIN `km_member` "
					+ "AS b ON a.`seller` = b.`uid` " + "WHERE `deleteYn` = 'N' ");
			// 로그인한 사람이 최고관리자(level:7)가 아닐경우 자신이 등록한 상품만 조회
			if (searchForm.getLevel() != 7) {
				sql.append(" AND a.`seller` = ? ");
			}
			// 검색조건에 따라서 조회
			if (searchForm.getSearchType().equals("prodName")) {
				sql.append(" AND a.`prodName` LIKE CONCAT('%', ?, '%') ");
			} else if (searchForm.getSearchType().equals("prodNo")) {
				sql.append(" AND a.`prodNo` LIKE CONCAT('%', ?, '%') ");
			} else if (searchForm.getSearchType().equals("company")) {
				sql.append(" AND a.`company` LIKE CONCAT('%', ?, '%') ");
			} else if (searchForm.getSearchType().equals("seller")) {
				sql.append(" AND b.`name` LIKE CONCAT('%', ?, '%') ");
			}

			// 한 페이지당 10개씩만 가져오도록 LIMIT
			sql.append(" LIMIT ?, 10");
			psmt = getConnection().prepareStatement(sql.toString());

			// 최고관리자와 아닌사람의 분리
			if (searchForm.getLevel() == 7) {
				psmt.setString(1, searchForm.getSearch());
				psmt.setInt(2, start);
			} else {
				psmt.setString(1, searchForm.getUid());
				psmt.setString(2, searchForm.getSearch());
				psmt.setInt(3, start);
			}
			rs = psmt.executeQuery(); // db의 데이터를 조회할 때 사용
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
				dto.setName(rs.getString("name"));
				products.add(dto);
			}
			close();
		} catch (Exception e) {
			logger.error("selectProducts error : " + e.getMessage());
		}
		return products;
	}

	public void updateProduct(ProductDTO dto) {

	}

	public void deleteProduct(String in) {
		try {
			String sql = "UPDATE `km_product` SET `deleteYn` = 'Y' WHERE `prodNo` IN " + in;
			stmt = getConnection().createStatement();
			stmt.executeUpdate(sql);
			close();
		} catch (Exception e) {
			logger.error("deleteProduct error : " + e.getMessage());
		}
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

	public int selectCountTotal(String uid, int level, ProductSearchForm searchForm) {
		int count = 0;
		try {
			String sql = "";
			// 최고관리자 level:7이라면 전체 상품의 갯수 조회
			if (level == 7) {
				sql = "SELECT COUNT(*) FROM `km_product` AS a "
						+ "JOIN `km_member` AS b ON a.`seller` = b.`uid` "
						+ "WHERE `deleteYn` = 'N'";
			} else {
				sql = "SELECT COUNT(*) FROM `km_product` AS a "
						+ "JOIN `km_member` AS b ON a.`seller` = b.`uid` "
						+ "WHERE `deleteYn` = 'N' AND `seller` = ?";
			}
			// 검색조건에 따라서 조회
			if (searchForm.getSearchType().equals("prodName")) {
				sql += " AND a.`prodName` LIKE CONCAT('%', ?, '%') ";
			} else if (searchForm.getSearchType().equals("prodNo")) {
				sql += " AND a.`prodNo` LIKE CONCAT('%', ?, '%') ";
			} else if (searchForm.getSearchType().equals("company")) {
				sql += " AND a.`company` LIKE CONCAT('%', ?, '%') ";
			} else if (searchForm.getSearchType().equals("seller")) {
				sql += " AND b.`name` LIKE CONCAT('%', ?, '%') ";
			}
			
			if (level == 7) {
				psmt = getConnection().prepareStatement(sql);
				psmt.setString(1, uid);
			} else {
				psmt = getConnection().prepareStatement(sql);
				psmt.setString(1, uid);
				psmt.setString(2, searchForm.getSearch());
			}
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