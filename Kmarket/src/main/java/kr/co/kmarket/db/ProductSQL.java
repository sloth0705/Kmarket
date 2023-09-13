package kr.co.kmarket.db;

public class ProductSQL {
	public static String SELECT_PRODUCTS = 
			"SELECT a.*, b.`c1Name`, c.`c2Name` "
			+ "FROM `km_product` AS a "
			+ "LEFT OUTER JOIN `km_product_cate1` AS b "
			+ "ON a.`prodCate1` = b.`cate1` "
			+ "LEFT OUTER JOIN `km_product_cate2` AS c ON "
			+ "a.`prodCate2` = c.`cate2` AND a.`prodCate1` = c.`cate1` "
			+ "WHERE a.`prodCate1` = ? AND "
			+ "a.`prodCate2` = ? " 
			+ "ORDER BY ? " 
			+ "LIMIT ?, 5";
	public static String SELECT_PRODUCT_COUNT_TOTAL = 
			"SELECT COUNT(*) "
			+ "FROM `km_product` "
			+ "WHERE `prodCate1` = ? AND " 
			+ "`prodCate2` = ?";
	public static String SELECT_PRODUCT = 
			"SELECT * "
			+ "FROM `km_product` "
			+ "WHERE `prodNo` = ?";
	public static String SELECT_PRODUCT_CARTS =
			"SELECT a.*, "
			+ "b.`prodName`, "
			+ "b.`descript`, "
			+ "b.`price`, "
			+ "b.`discount`, "
			+ "b.`point`, "
			+ "b.`delivery`, "
			+ "b.`thumb1`"
			+ "FROM `km_product_cart` AS a "
			+ "LEFT OUTER JOIN `km_product` AS b "
			+ "ON a.`prodNo` = b.`prodNo` "
			+ "WHERE `uid` = ?";
	public static String DELETE_CART =
			"DELETE FROM `km_product_cart` "
			+ "WHERE `cartNo` = ?";
	public static String SELECT_CHECKED_PRODUCT_CARTS =
			"SELECT a.*, "
			+ "b.`prodName`, "
			+ "b.`descript`, "
			+ "b.`price`, "
			+ "b.`discount`, "
			+ "b.`point`, "
			+ "b.`delivery`, "
			+ "b.`thumb1`"
			+ "FROM `km_product_cart` AS a "
			+ "LEFT OUTER JOIN `km_product` AS b "
			+ "ON a.`prodNo` = b.`prodNo` "
			+ "WHERE a.`cartNo` IN ";
}