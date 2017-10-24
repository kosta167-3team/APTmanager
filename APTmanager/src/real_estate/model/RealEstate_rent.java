package real_estate.model;

import java.io.Serializable;

public class RealEstate_rent implements Serializable{

	private int rr_id;
	private String a_name;
	private int rr_year;
	private int rr_month;
	private String rr_type = "전세";
	private int rr_deposit;
	private int rr_m_price;
	private int rr_max;
	private int rr_min;
	private int rr_area;
	
	public RealEstate_rent(){	}

	public RealEstate_rent(String a_name, int rr_year, int rr_month, int rr_deposit, int rr_m_price, int rr_area) {
		super();
		this.a_name = a_name;
		this.rr_year = rr_year;
		this.rr_month = rr_month;
		this.rr_deposit = rr_deposit;
		this.rr_m_price = rr_m_price;
		this.rr_area = rr_area;
	}

	public int getRr_id() {
		return rr_id;
	}

	public void setRr_id(int rr_id) {
		this.rr_id = rr_id;
	}

	public String getRr_name() {
		return a_name;
	}

	public void setRr_name(String a_name) {
		this.a_name = a_name;
	}

	public int getRr_year() {
		return rr_year;
	}

	public void setRr_year(int rr_year) {
		this.rr_year = rr_year;
	}

	public int getRr_month() {
		return rr_month;
	}

	public void setRr_month(int rr_month) {
		this.rr_month = rr_month;
	}

	public String getRr_type() {
		return rr_type;
	}

	public void setRr_type(String rr_type) {
		this.rr_type = rr_type;
	}

	public int getRr_deposit() {
		return rr_deposit;
	}

	public void setRr_deposit(int rr_deposit) {
		this.rr_deposit = rr_deposit;
	}

	public int getRr_m_price() {
		return rr_m_price;
	}

	public void setRr_m_price(int rr_m_price) {
		this.rr_m_price = rr_m_price;
	}

	public int getRr_area() {
		return rr_area;
	}

	public void setRr_area(int rr_area) {
		this.rr_area = rr_area;
	}

	public int getRr_max() {
		return rr_max;
	}

	public void setRr_max(int rr_max) {
		this.rr_max = rr_max;
	}

	public int getRr_min() {
		return rr_min;
	}

	public void setRr_min(int rr_min) {
		this.rr_min = rr_min;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	@Override
	public String toString() {
		return "RealEstate_rent [rr_id=" + rr_id + ", a_name=" + a_name + ", rr_year=" + rr_year + ", rr_month="
				+ rr_month + ", rr_type=" + rr_type + ", rr_deposit=" + rr_deposit + ", rr_m_price=" + rr_m_price
				+ ", rr_max=" + rr_max + ", rr_min=" + rr_min + ", rr_area=" + rr_area + "]";
	}
	
	 
}