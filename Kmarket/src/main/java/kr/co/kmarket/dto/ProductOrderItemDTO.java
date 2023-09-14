package kr.co.kmarket.dto;

import java.text.DecimalFormat;

public class ProductOrderItemDTO {
	private int ordNo;
	private int prodNo;
	private int count;
	private ProductDTO product;

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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	
	public int getDisTotal() {
		return count * product.getDisPrice();
	}
	
	public String getDisTotalWithComma() {
		int price =  count * product.getDisPrice();
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(price);
	}
}