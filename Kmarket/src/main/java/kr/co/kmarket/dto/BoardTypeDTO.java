package kr.co.kmarket.dto;

import java.util.List;

public class BoardTypeDTO {
	private String cate;
	private int type;
	private String typeName;
	
	/* 
	 이걸 들고 있어야 faq에서 더보기에서 varStatus로 준 index값이 안꼬임
		-> 반복문이 돌 때 index값이 지 ㅈ대로 돌아갈수 있기 때문이라네
		=> 이러고 난 뒤 controller에서 먼저 반복문을 통해
		boardTypeDTO가 CS_BoardDTO를 가지고 있어야됨
	*/ 
	private List<CS_BoardDTO> dto;
	public List<CS_BoardDTO> getDto() {
		return dto;
	}
	public void setDto(List<CS_BoardDTO> dto) {
		this.dto = dto;
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
