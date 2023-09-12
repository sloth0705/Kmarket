package kr.co.kmarket.dto;

public class Km_member_terms {
	private String terms;
	private String privacy;
	private String finance;
	private String location;
	private String tax;

	@Override
	public String toString() {
		return "Km_member_terms [terms=" + terms + ", privacy=" + privacy + ", finance=" + finance + ", location="
				+ location + ", tax=" + tax + "]";
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getFinance() {
		return finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
}