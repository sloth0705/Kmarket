package kr.co.kmarket.dto;

public class CS_BoardDTO {
	private int bno;
	private String uid;
	private int type1;
	private int type2;
	private String title;
	private String content;
	private String rdate;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getType1() {
		return type1;
	}
	public void setType1(int type1) {
		this.type1 = type1;
	}
	public int getType2() {
		return type2;
	}
	public void setType2(int type2) {
		this.type2 = type2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRdate() {
		return rdate.substring(2,11);
	}
	public String getPullRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "CS_BoardDTO [bno=" + bno + ", uid=" + uid + ", type1=" + type1 + ", type2=" + type2 + ", title=" + title
				+ ", content=" + content + ", rdate=" + rdate + "]";
	}
	
}