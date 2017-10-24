package real_estate.model;

import java.io.Serializable;

public class RealEstate_trade implements Serializable {

	private int rt_id;
	private String a_name;
	private int rt_year;
	private int rt_month;
	private int rt_max;
	private int rt_min;
	private int rt_price;
	private int rt_area;

	
	public RealEstate_trade() {
		// TODO Auto-generated constructor stub
	}


	public RealEstate_trade(String a_name, int rt_year, int rt_month, int rt_price, int rt_area) {
		super();
		this.a_name = a_name;
		this.rt_year = rt_year;
		this.rt_month = rt_month;
		this.rt_price = rt_price;
		this.rt_area = rt_area;
	}


	

	public int getRt_id() {
		return rt_id;
	}


	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}


	public String getA_name() {
		return a_name;
	}


	public void setA_name(String a_name) {
		this.a_name = a_name;
	}


	public int getRt_year() {
		return rt_year;
	}


	public void setRt_year(int rt_year) {
		this.rt_year = rt_year;
	}


	public int getRt_month() {
		return rt_month;
	}


	public void setRt_month(int rt_month) {
		this.rt_month = rt_month;
	}


	public int getRt_max() {
		return rt_max;
	}


	public void setRt_max(int rt_max) {
		this.rt_max = rt_max;
	}


	public int getRt_min() {
		return rt_min;
	}


	public void setRt_min(int rt_min) {
		this.rt_min = rt_min;
	}


	public int getRt_price() {
		return rt_price;
	}


	public void setRt_price(int rt_price) {
		this.rt_price = rt_price;
	}


	public int getRt_area() {
		return rt_area;
	}


	public void setRt_area(int rt_area) {
		this.rt_area = rt_area;
	}


	@Override
	public String toString() {
		return "RealEstate_trade [a_name=" + a_name + ", rt_year=" + rt_year + ", rt_month=" + rt_month + ", rt_price="
				+ rt_price + ", rt_area=" + rt_area + "]";
	}
	
	
}