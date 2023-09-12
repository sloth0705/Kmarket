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

}