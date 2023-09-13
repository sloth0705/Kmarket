package kr.co.kmarket.db;

public class SQL {

	// Member
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
	public static final String INSERT_MEMBER = "INSERT INTO `km_member` SET "
											+ "`uid`=?, "
											+ "`pass`=SHA2(?, 256), "
											+ "`name`=?, "
											+ "`gender`=?, "
											+ "`hp`=?, "
											+ "`email`=?, "
											+ "`type`=?, "
											+ "`level`=?, "
											+ "`zip`=?, "
											+ "`addr1`=?, "
											+ "`addr2`=?, "
											+ "`company`=?, "
											+ "`ceo`=?, "
											+ "`bizRegNum`=?, "
											+ "`comRegNum`=?, "
											+ "`tel`=?, "
											+ "`manager`=?, "
											+ "`managerHp`=?, "
											+ "`fax`=?, "
											+ "`regip`=?, "
											+ "`rdate`=NOW()";
	public static final String SELECT_MEMBER = "SELECT * FROM `km_member` WHERE `uid`=? AND `pass`=SHA2(?, 256)";
	
	public static final String SELECT_COUNT_UID = "SELECT COUNT(*) FROM `km_member` WHERE `uid`=?";
	public static final String SELECT_COUNT_EMAIL = "SELECT COUNT(*) FROM `km_member` WHERE `email`=?";
	public static final String SELECT_COUNT_HP = "SELECT COUNT(*) FROM `km_member` WHERE `hp`=?";
	public static final String SELECT_COUNT_COMPANY = "SELECT COUNT(*) FROM `km_member` WHERE `company`=?";
	public static final String SELECT_COUNT_BIZREGNUM = "SELECT COUNT(*) FROM `km_member` WHERE `bizRegNum`=?";
	public static final String SELECT_COUNT_COMREGNUM = "SELECT COUNT(*) FROM `km_member` WHERE `comRegNum`=?";
	public static final String SELECT_COUNT_TEL = "SELECT COUNT(*) FROM `km_member` WHERE `tel`=?";
	public static final String SELECT_COUNT_FAX = "SELECT COUNT(*) FROM `km_member` WHERE `fax`=?";
}