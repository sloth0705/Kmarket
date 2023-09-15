package kr.co.kmarket.dto;

public class BoardCateDTO {
	private String cate;
	private String cateName;
	
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	@Override
	public String toString() {
		return "BoardCateDTO [cate=" + cate + ", cateName=" + cateName + ", type=" + type + "]";
	}
	
}
