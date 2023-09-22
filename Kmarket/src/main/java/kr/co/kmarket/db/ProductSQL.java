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
			+ "LIMIT ?, 10";
	public static String SELECT_PRODUCTS1 = 
			"SELECT a.*, b.`c1Name`, c.`c2Name` "
					+ "FROM `km_product` AS a "
					+ "LEFT OUTER JOIN `km_product_cate1` AS b "
					+ "ON a.`prodCate1` = b.`cate1` "
					+ "LEFT OUTER JOIN `km_product_cate2` AS c ON "
					+ "a.`prodCate2` = c.`cate2` AND a.`prodCate1` = c.`cate1` "
					+ "WHERE a.`deleteYn` = 'N' "
					+ "AND a.`prodCate1` = ? AND "
					+ "a.`prodCate2` = ? " 
					+ "ORDER BY ";
	public static String SELECT_PRODUCTS2 = 
					" LIMIT ?, 10";
	public static String SELECT_PRODUCT_COUNT_TOTAL = 
			"SELECT COUNT(*) "
			+ "FROM `km_product` "
			+ "WHERE `deleteYn` = 'N' "
			+ "AND `prodCate1` = ? AND " 
			+ "`prodCate2` = ?";
	public static String SELECT_PRODUCT = 
			"SELECT * "
			+ "FROM `km_product` "
			+ "WHERE `prodNo` = ?";
	public static String SELECT_PRODUCT_CARTS =
			"SELECT a.*, "
			+ "b.`prodName`, "
			+ "b.`prodCate1`, "
			+ "b.`prodCate2`, "
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
			+ "b.`prodCate1`, "
			+ "b.`prodCate2`, "
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
	public static String INSERT_PRODUCT_CART = 
			"INSERT INTO `km_product_cart` "
			+ "SET `uid` = ?, "
			+ "`prodNo` = ?, "
			+ "`count` = ? ,"
			+ "`rdate` = NOW()";
	public static String INSERT_PRODUCT_ORDER =
			"INSERT INTO `km_product_order` "
			+ "SET `ordUid` = ?, "
			+ "`ordCount` = ?, "
			+ "`ordPrice` = ?, "
			+ "`ordDiscount` = ?, "
			+ "`ordDelivery` = ?, "
			+ "`usedPoint` = ?, "
			+ "`ordTotPrice` = ?, "
			+ "`recipName` = ?, "
			+ "`recipHp` = ?, "
			+ "`recipZip` = ?, "
			+ "`recipAddr1` = ?, "
			+ "`recipAddr2` = ?, "
			+ "`ordPayment` = ?, "
			+ "`ordComplete` = 1, "
			+ "`ordDate` = NOW() ";
	public static String SELECT_MAX_ORDNO = 
			"SELECT MAX(`ordNo`) "
			+ "FROM `km_product_order`";
	public static String INSERT_PRODUCT_ORDER_ITEM = 
			"INSERT INTO `km_product_order_item` "
			+ "SET `ordNo` = ?, "
			+ "`prodNo` = ?, "
			+ "`count` = ?";
	public static String USE_POINT = 
			"UPDATE `km_member` "
			+ "SET `point` = `point` - ? "
			+ "WHERE `uid` = ?";
	public static String SAVE_POINT = 
			"UPDATE `km_member` "
			+ "SET `point` = `point` + ? "
			+ "WHERE `uid` = ?";
	public static String SELECT_PRODUCT_ORDER =
			"SELECT a.*, b.`name` FROM `km_product_order` AS a "
			+ "LEFT OUTER JOIN `km_member` AS b ON a.`ordUid` = b.`uid` "
			+ "WHERE a.`ordNo` = ?";
	public static String SELECT_PRODUCT_ORDER_ITEMS =
			"SELECT b.*, a.`ordNo`, a.`count` "
			+ "FROM `km_product_order_item` AS a "
			+ "LEFT OUTER JOIN `km_product` AS b ON a.`prodNo` = b.`prodNo` "
			+ "WHERE a.`ordNo` = ?";
	public static String INSERT_MEMBER_POINT = 
			"INSERT INTO `km_member_point` "
			+ "SET `uid` = ?, "
			+ "`ordNo` = ?, "
			+ "`point` = ?,"
			+ "`pointDate` = NOW()";
	public static String SELECT_PRODUCT_CATE2 = 
			"SELECT a.*, b.`c1Name` FROM `km_product_cate2` AS a "
			+ "JOIN `km_product_cate1` AS b "
			+ "ON a.`cate1` = b.`cate1` "
			+ "WHERE a.`cate1` = ? "
			+ "AND a.`cate2` = ?";
	public static String SELECT_SEARCH_PRODUCT_COUNT_TOTAL = 
			"SELECT COUNT(*) "
			+ "FROM `km_product` "
			+ "WHERE `deleteYn` = 'N' "
			+ "AND `prodName` LIKE CONCAT('%', ?, '%')";
	public static String SELECT_PRODUCTS_BY_SEARCH1 = 
			"SELECT a.*, b.`c1Name`, c.`c2Name` "
			+ "FROM `km_product` AS a "
			+ "LEFT OUTER JOIN `km_product_cate1` AS b "
			+ "ON a.`prodCate1` = b.`cate1` "
			+ "LEFT OUTER JOIN `km_product_cate2` AS c ON "
			+ "a.`prodCate2` = c.`cate2` AND a.`prodCate1` = c.`cate1` "
			+ "WHERE a.`deleteYn` = 'N' "
			+ "AND a.`prodName` LIKE CONCAT('%', ?, '%') "
			+ "ORDER BY ";
	public static String SELECT_PRODUCTS_BY_SEARCH2 = 
			" LIMIT ?, 10";
	public static String SELECT_PRODUCTS_BY_REASON_LIMIT1 = 
			"SELECT a.*, b.`c1Name`, c.`c2Name` "
					+ "FROM `km_product` AS a "
					+ "LEFT OUTER JOIN `km_product_cate1` AS b "
					+ "ON a.`prodCate1` = b.`cate1` "
					+ "LEFT OUTER JOIN `km_product_cate2` AS c ON "
					+ "a.`prodCate2` = c.`cate2` AND a.`prodCate1` = c.`cate1` "
					+ "WHERE a.`deleteYn` = 'N' "
					+ "ORDER BY ";
}