package facility_reservation.model;

public class Facility_time {

	private int t_id;
	private String t_start;
	private String t_end;
	
	public Facility_time(){}

	public Facility_time(int t_id, String t_start, String t_end) {
		super();
		this.t_id = t_id;
		this.t_start = t_start;
		this.t_end = t_end;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_start() {
		return t_start;
	}

	public void setT_start(String t_start) {
		this.t_start = t_start;
	}

	public String getT_end() {
		return t_end;
	}

	public void setT_end(String t_end) {
		this.t_end = t_end;
	}
	
	
}
