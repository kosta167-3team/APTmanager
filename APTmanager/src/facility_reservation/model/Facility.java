package facility_reservation.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Facility {

	private int f_id;
	private String f_name;
	private String f_contents;
	private int f_capa;
	private String f_state;
	private String f_open;
	private String f_close;

	public Facility() {

	}

	public Facility(int f_id, String f_name, String f_contents, int f_capa, String f_state, String f_open,
			String f_close) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_contents = f_contents;
		this.f_capa = f_capa;
		this.f_state = f_state;
		this.f_open = f_open;
		this.f_close = f_close;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_contents() {
		return f_contents;
	}

	public void setF_contents(String f_contents) {
		this.f_contents = f_contents;
	}

	public int getF_capa() {
		return f_capa;
	}

	public void setF_capa(int f_capa) {
		this.f_capa = f_capa;
	}

	public String getF_state() {
		return f_state;
	}

	public void setF_state(String f_state) {
		this.f_state = f_state;
	}

	public String getF_open() {
		return f_open;
	}

	public void setF_open(String f_open) {
		this.f_open = f_open;
	}

	public String getF_close() {
		return f_close;
	}

	public void setF_close(String f_close) {
		this.f_close = f_close;
	}

	public List<Timestamp> Set_date() {

		List<Timestamp> date = new ArrayList<Timestamp>();

		for (int i = 1; i < 8; i++) {

			Timestamp now = new Timestamp(System.currentTimeMillis());

			int today = now.getDate();
			now.setDate(today + i);

			date.add(now);
		}

		return date;
	}

}
