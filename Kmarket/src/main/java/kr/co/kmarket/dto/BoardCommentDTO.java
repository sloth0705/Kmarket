package kr.co.kmarket.dto;

public class BoardCommentDTO {
	private int cno;
	private int re_bno;
	private String group;
	private String cate;
	private String uid;
	private String content;
	private String rdate;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRdate() {
		return rdate.substring(2, 11);
	}
	public String getRdateAll() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getRe_bno() {
		return re_bno;
	}
	public void setRe_bno(int re_bno) {
		this.re_bno = re_bno;
	}
	
	@Override
	public String toString() {
		return "BoardComment [cno=" + cno + ", re_bno=" + re_bno + ", group=" + group + ", cate=" + cate + ", uid="
				+ uid + ", content=" + content + ", rdate=" + rdate + "]";
	}
}
