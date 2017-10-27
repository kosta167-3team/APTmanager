package real_estate.model;

import java.io.Serializable;

public class RealEstate_Area implements Serializable {
	int area;
	int rr_max;
	int rr_min;
	int rt_max;
	int rt_min;
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
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
	
	
}
