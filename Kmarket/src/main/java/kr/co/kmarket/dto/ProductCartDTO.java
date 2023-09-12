package kr.co.kmarket.dto;

public class ProductCartDTO {
	private int cartNo;
	private String uid;
	private int prodNo;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int delivery;
	private int total;
	private String rdate;

	@Override
	public String toString() {
		return "Km_product_cart [cartNo=" + cartNo + ", uid=" + uid + ", prodNo=" + prodNo + ", count=" + count
				+ ", price=" + price + ", discount=" + discount + ", point=" + point + ", delivery=" + delivery
				+ ", total=" + total + ", rdate=" + rdate + "]";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
}