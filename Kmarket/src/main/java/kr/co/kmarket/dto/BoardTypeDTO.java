package kr.co.kmarket.dto;

public class BoardTypeDTO {
	private String cate;
	private int type;
	private String typeName;
	
	
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return "BoardTypeDTO [cate=" + cate + ", type=" + type + ", typeName=" + typeName + "]";
	}
}
