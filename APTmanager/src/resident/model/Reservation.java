package resident.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reservation implements Serializable {
	private String vr_id;
	private String r_id;
	private String v_name;
	private String v_tel;
	private String v_date;
	private String vr_date;
	private String v_contents;
	private String v_check;
	public Reservation() {}
	public String getVr_date() {
		return vr_date;
	}

	public void setVr_date(String vr_date) {
		this.vr_date = vr_date;
	}
	public String getVr_id() {
		return vr_id;
	}

	public void setVr_id(String vr_id) {
		this.vr_id = vr_id;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getV_tel() {
		return v_tel;
	}

	@Override
	public String toString() {
		return "Reservation [vr_id=" + vr_id + ", r_id=" + r_id + ", v_name=" + v_name + ", v_tel=" + v_tel
				+ ", v_date=" + v_date + ", vr_date=" + vr_date + ", v_contents=" + v_contents + ", v_check=" + v_check
				+ "]";
	}

	public void setV_tel(String v_tel) {
		this.v_tel = v_tel;
	}

	public String getV_date() {
		return v_date;
	}

	public void setV_date(String v_date) {
		this.v_date = v_date;
	}

	public String getV_contents() {
		return v_contents;
	}

	public void setV_contents(String v_contents) {
		this.v_contents = v_contents;
	}

	public String getV_check() {
		return v_check;
	}

	public void setV_check(String v_check) {
		this.v_check = v_check;
	}
	
	
}
