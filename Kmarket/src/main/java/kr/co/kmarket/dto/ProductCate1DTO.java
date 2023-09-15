package kr.co.kmarket.dto;

import java.util.List;

public class ProductCate1DTO {
	private int cate1;
	private String c1Name;
	private String css;

	private List<ProductCate2DTO> cate2;

	public List<ProductCate2DTO> getCate2() {
		return cate2;
	}

	public void setCate2(List<ProductCate2DTO> cate2) {
		this.cate2 = cate2;
	}

	@Override
	public String toString() {
		return "Km_product_cate1 [cate1=" + cate1 + ", c1Name=" + c1Name + "]";
	}

	public int getCate1() {
		return cate1;
	}

	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}

	public String getC1Name() {
		return c1Name;
	}

	public void setC1Name(String c1Name) {
		this.c1Name = c1Name;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}
}