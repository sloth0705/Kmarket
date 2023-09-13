package kr.co.kmarket.dto;

import java.text.DecimalFormat;

public class ProductCartDTO {
	private int cartNo;
	private String uid;
	private int prodNo;
	private int count;
	private String rdate;
	private ProductDTO product;

	@Override
	public String toString() {
		return "ProductCartDTO [cartNo=" + cartNo + ", uid=" + uid + ", prodNo=" + prodNo + ", count=" + count
				+ ", rdate=" + rdate + "]";
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public int getTotal() {
		return (int)(((double) count) * product.getDisPrice());
	}

	public String getTotalWithComma() {
		int total = (int)(((double) count) * product.getDisPrice());
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(total);
	}
}