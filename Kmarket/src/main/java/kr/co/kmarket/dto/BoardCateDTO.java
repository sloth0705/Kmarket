package kr.co.kmarket.dto;

public class BoardCateDTO {
	private String cate;
	private String cateName;
	
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
		return "BoardCateDTO [cate=" + cate + ", cateName=" + cateName + "]";
	}
}
