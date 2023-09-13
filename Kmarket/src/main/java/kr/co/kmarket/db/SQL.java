package kr.co.kmarket.db;

public class SQL {
	// cs
	public static final String INSERT_CS_BOARD 
		= "INSERT INTO km_cs_board SET "
				+ " uid = ?, "
				+ " type1 = ?, "
				+ " type2 = ?, "
				+ " title = ?, "
				+ " content = ?, "
				+ " rdate = NOW()";
	
	
	public static final String SELECT_CS_BOARDS 
		= "SELECT * FROM km_cs_board ";


	public static String SELECT_PRODUCTS = "SELECT a.*, b.`c1Name`, c.`c2Name` FROM `km_product` AS a "
											+ "LEFT OUTER JOIN `km_product_cate1` AS b ON a.`prodCate1` = b.`cate1` "
											+ "LEFT OUTER JOIN `km_product_cate2` AS c ON a.`prodCate2` = c.`cate2` AND a.`prodCate1` = c.`cate1` "
											+ "WHERE a.`prodCate1` = ? AND a.`prodCate2` = ? "
											+ "ORDER BY ? "
											+ "LIMIT ?, 5";
	public static String SELECT_PRODUCT_COUNT_TOTAL = "SELECT COUNT(*) FROM `km_product` "
													+ "WHERE `prodCate1` = ? AND "
													+ "`prodCate2` = ?";
	public static String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";

}