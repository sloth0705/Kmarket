package kr.co.kmarket.dto;

public class ProductOrderItemDTO {
	private int ordNo;
	private int prodNo;
	private int count;

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = Integer.parseInt(prodNo);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void setCount(String count) {
		this.count = Integer.parseInt(count);
	}
}