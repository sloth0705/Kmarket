package kr.co.kmarket.dto;

public class CS_BoardDTO {
	private int bno;
	private String uid;
	private String group;
	private String cate;
	private int type;
	private String title;
	private String content;
	private String rdate;
	
	private String cateName;
	private String typeName;
	
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUid() {
		return uid;
	}
	public String maskingUid(String uid) {
		StringBuilder maskingUid = new StringBuilder(uid);
		int length = uid.length();
		if(length > 1) {
			for(int i = 1; i < Math.max(2, length - 1); i++) {
				maskingUid.setCharAt(i, '*');
			}
		}
		return maskingUid.toString();
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
		return rdate.substring(2, 11);
	}
	public String getRdateAll() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	@Override
	public String toString() {
		return "CS_BoardDTO [bno=" + bno + ", uid=" + uid + ", group=" + group + ", cate=" + cate + ", type=" + type
				+ ", title=" + title + ", content=" + content + ", rdate=" + rdate + ", cateName=" + cateName
				+ ", typeName=" + typeName + "]";
	}
	
}